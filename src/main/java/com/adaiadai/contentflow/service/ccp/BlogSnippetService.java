package com.adaiadai.contentflow.service.ccp;

import com.adaiadai.contentflow.constant.ccp.BlogSnippetType;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogId;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogSnippet;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogSnippetRepository;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @author adai
 */
@Service
public class BlogSnippetService {

    @Autowired
    private BlogSnippetRepository blogSnippetRepository;

    public List<BlogSnippet> blogSnippetsOfBlogId(BlogId blogId) {
        return (List<BlogSnippet>) blogSnippetRepository.blogSnippetsOfBlogId(blogId);
    }

    public void associate(BlogId blogId, Snippet snippet, BlogSnippetType type, Integer rank) {
        blogSnippetRepository.add(new BlogSnippet(blogId, snippet, type, rank));
    }

    public void associate(BlogSnippet blogSnippet) {
        blogSnippetRepository.add(blogSnippet);
    }

    public void associate(Collection<BlogSnippet> blogSnippets) {
        blogSnippetRepository.addAll(blogSnippets);
    }

    public void removeAll(Collection<BlogSnippet> blogSnippets) {
        blogSnippetRepository.removeAll(blogSnippets);
    }

    public void removeAllByBlogId(BlogId blogId) {
        blogSnippetRepository.removeAll(blogSnippetRepository.blogSnippetsOfBlogId(blogId));
    }

}
