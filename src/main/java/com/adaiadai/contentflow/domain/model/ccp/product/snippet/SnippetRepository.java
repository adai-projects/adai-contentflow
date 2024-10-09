package com.adaiadai.contentflow.domain.model.ccp.product.snippet;

import com.adaiadai.contentflow.domain.model.ccp.collaborator.Creator;

import java.util.Collection;

/**
 * @author adai
 */
public interface SnippetRepository {

    SnippetId nextIdentity();

    Snippet snippetOfSnippetId(SnippetId snippetId);

    Collection<Snippet> snippetsOfCreator(Creator creator);

    Collection<Snippet> snippetsOfCreatorAndScope(Creator creator, Integer scope);

    Collection<Snippet> snippetsOfScope(Integer scope);

    void add(Snippet snippet);

    void remove(Snippet snippet);
}
