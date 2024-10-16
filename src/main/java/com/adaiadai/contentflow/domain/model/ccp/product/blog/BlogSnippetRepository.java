package com.adaiadai.contentflow.domain.model.ccp.product.blog;

import java.util.Collection;

/**
 * @author adai
 */
public interface BlogSnippetRepository {

    Collection<BlogSnippet> blogSnippetsOfBlogId(BlogId blogId);

    void add(BlogSnippet blogSnippet);

    void addAll(Collection<BlogSnippet> blogSnippets);

    void removeAll(Collection<BlogSnippet> blogSnippets);
}
