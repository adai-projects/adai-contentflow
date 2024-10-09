package com.adaiadai.contentflow.repository.ccp;

import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogId;
import com.adaiadai.contentflow.domain.model.ccp.product.blog.BlogSnippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface BlogSnippetJpaRepository extends JpaRepository<BlogSnippet, Long> {

    List<BlogSnippet> findAllByBlogId(BlogId blogId);
}
