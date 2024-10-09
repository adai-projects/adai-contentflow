package com.adaiadai.contentflow.application.ccp;

import com.adaiadai.contentflow.application.iaa.IdentityApplicationService;
import com.adaiadai.contentflow.application.sis.ReadingApplicationService;
import com.adaiadai.contentflow.application.sis.TagApplicationService;
import com.adaiadai.contentflow.constant.DataLayout;
import com.adaiadai.contentflow.constant.ccp.BlogSnippetType;
import com.adaiadai.contentflow.constant.ccp.ScopeConstant;
import com.adaiadai.contentflow.domain.model.ccp.collaborator.Blogger;
import com.adaiadai.contentflow.domain.model.ccp.collaborator.Creator;
import com.adaiadai.contentflow.domain.model.ccp.product.ProductType;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.Blog;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogId;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogSnippet;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetId;
import com.adaiadai.contentflow.exception.MxException;
import com.adaiadai.contentflow.representation.ccp.blog.dto.BlogCardDTO;
import com.adaiadai.contentflow.representation.ccp.blog.form.BlogConfigModifyForm;
import com.adaiadai.contentflow.representation.ccp.blog.form.BlogCreateForm;
import com.adaiadai.contentflow.representation.ccp.blog.form.BlogModifyForm;
import com.adaiadai.contentflow.representation.ccp.blog.vo.*;
import com.adaiadai.contentflow.representation.sis.reader.dto.ReadingAtProductOutlineDTO;
import com.adaiadai.contentflow.representation.sis.tag.dto.TagAtProductDTO;
import com.adaiadai.contentflow.representation.sis.tag.dto.TagItemDTO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagAtProductVO;
import com.adaiadai.contentflow.service.ccp.BlogPagination;
import com.adaiadai.contentflow.service.ccp.BlogService;
import com.adaiadai.contentflow.service.ccp.BlogSnippetService;
import com.adaiadai.contentflow.service.ccp.SnippetService;
import com.adaiadai.contentflow.service.ccp.translator.BlogTranslator;
import com.adaiadai.contentflow.service.ccp.translator.ReaderTranslator;
import com.adaiadai.contentflow.service.ccp.translator.TagTranslator;
import com.adaiadai.contentflow.util.BlogUtil;
import com.adaiadai.contentflow.util.DataLayoutUtil;
import com.adaiadai.contentflow.util.MarkdownUtil;
import com.adaiadai.contentflow.util.SecurityUtil;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.adaiadai.contentflow.constant.ccp.BlogConstant.*;

/**
 * @author adai
 */
@Service
public class BlogApplicationService {
    private static final Logger logger = LoggerFactory.getLogger(BlogApplicationService.class);

    @Autowired
    private ReadingApplicationService readingApplicationService;
    @Autowired
    private TagApplicationService tagApplicationService;
    @Autowired
    private IdentityApplicationService identityApplicationService;

    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogSnippetService blogSnippetService;
    @Autowired
    private SnippetService snippetService;

    @Autowired
    private BlogTranslator blogTranslator;
    @Autowired
    private TagTranslator tagTranslator;
    @Autowired
    private ReaderTranslator readerTranslator;
    @Autowired
    private BlogPagination blogPagination;

    public boolean collectionNotAllow(String blogId) {
        return BLOG_NOT_ALLOW_COLLECT_TRUE.equals(blogService.getByBlogId(new BlogId(blogId)).collectionNotAllowed());
    }

    public Blog getByBlogId(String blogId) {
        Blog byBlogId = blogService.getByBlogId(new BlogId(blogId));
        if (blogId == null) {
            throw new MxException("博客不存在！");
        }
        return byBlogId;
    }

    public BlogVO<? extends BlogBaseVO> getBaseByBlogId(String blogId, String layout) {
        Blog blog = blogService.getByBlogId(new BlogId(blogId));
        DataLayout dataLayout = DataLayoutUtil.layout(layout);
        switch (dataLayout) {
            case DATA_LAYOUT_CARD:
                return new BlogVO<>(blogTranslator.convertToCardVo(blog));
            case DATA_LAYOUT_DETAIL:
                return new BlogVO<>(blogTranslator.convertToDetailVo(blog));
            default:
                return new BlogVO<>(blogTranslator.convertToBaseVo(blog));
        }
    }

    public BlogConfigModifyForm getConfigModifyFormByBlogId(String blogId) {
        return blogTranslator.convertToConfigModifyForm(getByBlogId(blogId));
    }

    public BlogDetailVO getDetailByBlogId(String blogId) {
        return blogTranslator.convertToDetailVo(blogService.getByBlogId(new BlogId(blogId)));
    }

    public BlogModifyForm getModifyFormByBlogId(String blogId) {
        return blogTranslator.convertToModifyForm(getByBlogId(blogId));
    }

    public List<? extends BlogBaseVO> listVo(String layout) {
        List<Blog> blogList = blogService.listByScope(ScopeConstant.SCOPE_PUBLIC);
        DataLayout dataLayout = DataLayoutUtil.layout(layout);
        switch (dataLayout) {
            case DATA_LAYOUT_DETAIL:
                return blogTranslator.convertToDetailVo(blogList);
            case DATA_LAYOUT_CARD:
                return blogTranslator.convertToCardVo(blogList);
            default:
                return blogTranslator.convertToBaseVo(blogList);
        }
    }

    public List<BlogCardDTO> listCardDtoByBlogIdList(List<String> blogIds) {
        if (blogIds != null && blogIds.size() > 0) {
            List<BlogId> blogIdList = new ArrayList<>(blogIds.size());
            blogIds.forEach(blogId -> blogIdList.add(new BlogId(blogId)));
            List<Blog> blogList = blogService.listByBlogIdList(blogIdList);
            List<BlogCardDTO> blogCardDtos = blogTranslator.convertToCardDto(blogList);
            // 补充数据，完整对象
            for (BlogCardDTO blogCardDto : blogCardDtos) {
                blogCardDto.setReadingAtProductOutlineDto(readingApplicationService.getReaderAtProductOutlineDtoByProduct(blogCardDto.getBlogId()
                        , ProductType.PRODUCT_BLOG.toString().toUpperCase()));
                blogCardDto.setTagItemDtoList(tagApplicationService.listItemDtoByProduct(blogCardDto.getBlogId()
                        , ProductType.PRODUCT_BLOG.toString().toUpperCase()));
            }
            return blogCardDtos;
        } else {
            return null;
        }
    }

    public List<BlogCardDTO> listCardDtoByIdentity(String identity) {
        List<BlogCardDTO> blogCardDtos = blogTranslator.convertToCardDto(blogService.listByBlogger(new Blogger(identity)));
        // 补充数据，完整对象
        for (BlogCardDTO blogCardDto : blogCardDtos) {
            blogCardDto.setReadingAtProductOutlineDto(readingApplicationService.getReaderAtProductOutlineDtoByProduct(blogCardDto.getBlogId()
                    , ProductType.PRODUCT_BLOG.toString().toUpperCase()));
            blogCardDto.setTagItemDtoList(tagApplicationService.listItemDtoByProduct(blogCardDto.getBlogId()
                    , ProductType.PRODUCT_BLOG.toString().toUpperCase()));
        }
        return blogCardDtos;
    }

    public List<BlogCardVO> listCardVoByIdentity(String username) {
        List<Blog> blogList;
        Blogger blogger = new Blogger(username);
        if (SecurityUtil.isPrincipal(username)) {
            // 列出博主未归档的博客
            blogList = blogService.listByBloggerAndArchived(blogger, BLOG_ARCHIVED_NOT_DEFAULT);
        } else {
            // 列出博客公开的博客
            blogList = blogService.listByBloggerAndScope(blogger, ScopeConstant.SCOPE_PUBLIC);
        }
        List<BlogCardVO> blogCardVoList = blogTranslator.convertToCardVo(blogList);
        // 补充数据，完整对象
        if (blogCardVoList != null && blogCardVoList.size() > 0) {
            for (BlogCardVO blogCardVo : blogCardVoList) {

                ReadingAtProductOutlineDTO readerAtProductOutlineDtoByProduct = readingApplicationService
                        .getReaderAtProductOutlineDtoByProduct(blogCardVo.getBlogId(), ProductType.PRODUCT_BLOG.toString().toUpperCase());
                if (readerAtProductOutlineDtoByProduct != null) {
                    blogCardVo.setReaderAtProductOutlineVo(readerTranslator.convertToReaderAtProductVo(readerAtProductOutlineDtoByProduct));
                }

                List<TagItemDTO> tagItemDtoList = tagApplicationService.listItemDtoByProduct(blogCardVo.getBlogId()
                        , ProductType.PRODUCT_BLOG.toString().toUpperCase());
                if (tagItemDtoList != null && tagItemDtoList.size() > 0) {
                    blogCardVo.setTagItemVoList(tagTranslator.convertToItemVo(tagItemDtoList));
                }
            }
        }

        return blogCardVoList;
    }

    public List<BlogCardDTO> listCardByBlogIdList(List<String> blogIds) {
        List<BlogId> blogIdList = new ArrayList<>(blogIds.size());
        blogIds.forEach(blogId -> blogIdList.add(new BlogId(blogId)));
        List<BlogCardDTO> blogCardDtoList = blogTranslator.convertToCardDto(blogService.listCardByBlogIdList(blogIdList));
        // 补充数据，完整对象
        for (BlogCardDTO blogCardDto : blogCardDtoList) {
            blogCardDto.setReadingAtProductOutlineDto(readingApplicationService
                    .getReaderAtProductOutlineDtoByProduct(blogCardDto.getBlogId(), ProductType.PRODUCT_BLOG.toString().toUpperCase()));
            blogCardDto.setTagItemDtoList(tagApplicationService.listItemDtoByProduct(blogCardDto.getBlogId(), ProductType.PRODUCT_BLOG.toString().toUpperCase()));
        }
        return blogCardDtoList;
    }

    public List<BlogManageVO> listManageVo() {
        List<Blog> blogList = blogService.listByBlogger(new Blogger(identityApplicationService.identity()));
        return blogTranslator.convertToManageVo(blogList);
    }

    public List<BlogCardVO> fillBlogCardVo(List<BlogCardVO> blogCardVoList) {
        // 补全数据，完整对象
        for (BlogCardVO cardVo : blogCardVoList) {
            List<TagItemDTO> tagItemDtos = tagApplicationService.listItemDtoByProduct(cardVo.getBlogId()
                    , ProductType.PRODUCT_BLOG.toString().toUpperCase());

            cardVo.setTagItemVoList(tagTranslator.convertToItemVo(tagItemDtos));
            ReadingAtProductOutlineDTO readingAtProductOutlineDto = readingApplicationService.getReaderAtProductOutlineDtoByProduct(cardVo.getBlogId()
                    , ProductType.PRODUCT_BLOG.toString().toUpperCase());
            cardVo.setReaderAtProductOutlineVo(readerTranslator.convertToReaderAtProductVo(readingAtProductOutlineDto));
        }
        return blogCardVoList;
    }

    public List<BlogCardVO> listPublicBlogs() {
        List<Blog> blogList = blogService.listByScope(ScopeConstant.SCOPE_PUBLIC);
        if (blogList != null && blogList.size() > 0) {
            return fillBlogCardVo(blogTranslator.convertToCardVo(blogList));
        } else {
            return null;
        }
    }

    public List<BlogCardVO> listCardByBlogList(List<Blog> blogList) {
        return fillBlogCardVo(blogTranslator.convertToCardVo(blogList));
    }

    public List<TagAtProductVO> listTagOfBlog(String blogId) {
        List<TagAtProductDTO> tagAtProductDtoList = tagApplicationService.listTagAtProductDto(blogId, ProductType.PRODUCT_BLOG.toString().toUpperCase());
        return tagTranslator.convertToTagAtProductVo(tagAtProductDtoList);
    }

    public Page<Blog> pageByKeyword(String keyword, Pageable pageable) {
        return blogPagination.pageByKeyword(keyword, pageable);
    }

    @Transactional(rollbackFor = {Exception.class})
    public BlogBaseVO createBlogByForm(BlogCreateForm blogCreateForm) {
        BlogId blogId = blogService.nextIdentity();
        Blog blog = new Blog(blogId, new Blogger(identityApplicationService.identity()));
        String content = blogCreateForm.getContent();
        LinkedList<String> snippets = MarkdownUtil.getSnippets(content);
        if (snippets.size() < 1) {
            throw new IllegalArgumentException("博客内容格式不正确");
        }
        // 博客主要内容
        String firstSnippet = snippets.get(0);
        // 确定标题和概要
        String title = blogCreateForm.getTitle();
        if (Strings.isNullOrEmpty(title)) {
            title = BlogUtil.getTitleNullable(firstSnippet);
        }
        if (title == null) {
            throw new IllegalArgumentException("请输入博客标题");
        }
        String summary = BlogUtil.getRegexResultNullable(BLOG_PATTERN_SUMMARY, firstSnippet);
        blog.setTitle(title);
        blog.setSummary(summary != null ? summary : title);
        blog.setContent(blogCreateForm.getContent());
        blog.setContentHtml(blogCreateForm.getContentHtml());
        blog.setScope(blogCreateForm.getScope());
        blog.setCollectionNotAllowed(blogCreateForm.getCollectionNotAllowed());
        blogService.add(blog);
        // TODO Event Publish
        // 处理片段
        List<BlogSnippet> blogSnippets = getBlogSnippets(snippets, blog.blogId(), blog.scope());
        blogSnippetService.associate(blogSnippets);
        // TODO Event Publish
        // 处理标签，如果标签字符串不为空
        if (Strings.emptyToNull(blogCreateForm.getTags()) != null) {
            tagApplicationService.addTagsToProduct(blogCreateForm.getTags(), blogId.id(), ProductType.PRODUCT_BLOG.toString().toUpperCase());
        }
        return blogTranslator.convertToBaseVo(blog);
    }

    private List<BlogSnippet> getBlogSnippets(List<String> snippets, BlogId blogId, Integer scopeOfBlog) {
        // 移除1级标题片段，只把二级标题做拆分
        snippets.remove(0);
        List<BlogSnippet> blogSnippets = new ArrayList<>();
        int rank = 0;
        for (String snippetContent : snippets) {
            int separator = snippetContent.indexOf("|");
            String title = snippetContent.substring(0, separator);
            String content = snippetContent.substring(separator + 1);
            rank = rank + 1;
            SnippetId snippetId = snippetService.nextIdentity();
            Snippet snippet = new Snippet(snippetId);
            snippet.setCreator(new Creator(identityApplicationService.identity()));
            snippet.setTitle(title.replace("H2_", ""));
            snippet.setDescription(title.replace("H2_", ""));
            snippet.setContent(content);
            // 关联片段范围：与博客范围一致
            snippet.setScope(scopeOfBlog);
            BlogSnippet blogSnippet = new BlogSnippet(blogId, snippet, BlogSnippetType.ORIGINAL, rank);
            blogSnippets.add(blogSnippet);
        }
        return blogSnippets;
    }

    @Transactional(rollbackFor = {Exception.class})
    public Blog modifyBlogByBlogId(String blogId, BlogModifyForm blogModifyForm) {
        Blog byCode = blogService.getByBlogId(new BlogId(blogId));
        byCode.setTitle("".equals(blogModifyForm.getTitle())
                ? BlogUtil.getRegexResultNullable(BLOG_PATTERN_H2_STYLE_1, blogModifyForm.getContent())
                : blogModifyForm.getTitle());
        byCode.setSummary(BlogUtil.getRegexResultNullable(BLOG_PATTERN_SUMMARY, blogModifyForm.getContent()));
        byCode.setContent(blogModifyForm.getContent());
        byCode.setContentHtml(blogModifyForm.getContentHtml());
        blogService.update(byCode);
        // 片段处理，先删除，后添加
        blogSnippetService.removeAllByBlogId(new BlogId(blogId));
        LinkedList<String> snippets = MarkdownUtil.getSnippets(blogModifyForm.getContent());
        List<BlogSnippet> blogSnippets = getBlogSnippets(snippets, byCode.blogId(), byCode.scope());
        blogSnippetService.associate(blogSnippets);
        return byCode;
    }

    @Transactional(rollbackFor = {Exception.class})
    public void modifyBlogConfigByBlogId(BlogId blogId, BlogConfigModifyForm blogConfigModifyForm) {
        Blog blog = blogService.getByBlogId(blogId);
        // 可修改配置
        blog.setScope(blogConfigModifyForm.getScope());
        blog.setCollectionNotAllowed(blogConfigModifyForm.getCollectionNotAllowed());
        blogService.add(blog);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void changeArchivedByBlogId(List<String> blogIds, Integer archived) {
        if (blogIds != null && blogIds.size() > 0) {
            List<BlogId> blogIdList = new ArrayList<>(blogIds.size());
            blogIds.forEach(blogId -> blogIdList.add(new BlogId(blogId)));
            blogService.patchAllArchived(blogIdList, archived);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteBlogByBlogId(String id) {
        BlogId blogId = new BlogId(id);
        Blog blog = blogService.getByBlogId(blogId);
        // 删除关联片段
        blogSnippetService.removeAllByBlogId(blogId);
        // 删除关联标签
        // TODO Event Publish
        tagApplicationService.deleteAllByProduct(blog.blogId().id(), ProductType.PRODUCT_BLOG.toString().toUpperCase());
        blogService.deleteByBlogId(blogId);
    }

    @Transactional(rollbackFor = {Exception.class})
    public void deleteAllByBlogger(String identity) {
        blogService.removeAll(blogService.listByBlogger(new Blogger(identity)));
    }

}
