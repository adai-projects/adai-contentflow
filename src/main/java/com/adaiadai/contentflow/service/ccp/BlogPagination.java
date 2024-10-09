package com.adaiadai.contentflow.service.ccp;

import com.adaiadai.contentflow.constant.ccp.ScopeConstant;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.Blog;
import com.adaiadai.contentflow.repository.ccp.BlogJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service
public class BlogPagination {

    @Autowired
    private BlogJpaRepository blogJpaRepository;

    public Page<Blog> pageByKeyword(String keyword, Pageable pageable) {
        if (!"".equals(keyword.trim())) {
            return blogJpaRepository.findDistinctByScopeAndTitleContainingOrSummaryContainingOrContentContaining(ScopeConstant.SCOPE_PUBLIC
                    , keyword
                    , keyword
                    , keyword
                    , pageable);
        } else {
            return blogJpaRepository.findDistinctByScope(ScopeConstant.SCOPE_PUBLIC, pageable);
        }
    }
}
