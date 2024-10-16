package com.adaiadai.contentflow.repository.ccp;

import com.adaiadai.contentflow.domain.model.ccp.collaborator.Creator;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetId;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetRepository;
import com.adaiadai.contentflow.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernateSnippetRepository implements SnippetRepository {

    private final static String SNIPPET_ID_PREFIX = "ccp-snippet-";

    @Autowired
    private SnippetJpaRepository snippetJpaRepository;

    @Override
    public SnippetId nextIdentity() {
        return new SnippetId(SNIPPET_ID_PREFIX + UUIDUtil.getUuidPartOne());
    }

    @Override
    public Snippet snippetOfSnippetId(SnippetId snippetId) {
        return snippetJpaRepository.findBySnippetId(snippetId);
    }

    @Override
    public Collection<Snippet> snippetsOfCreator(Creator creator) {
        return snippetJpaRepository.findAllByCreator(creator);
    }

    @Override
    public Collection<Snippet> snippetsOfCreatorAndScope(Creator creator, Integer scope) {
        return snippetJpaRepository.findAllByScopeAndCreator(scope, creator);
    }

    @Override
    public Collection<Snippet> snippetsOfScope(Integer scope) {
        return snippetJpaRepository.findAllByScope(scope);
    }

    @Override
    public void add(Snippet snippet) {
        snippetJpaRepository.save(snippet);
    }

    @Override
    public void remove(Snippet snippet) {
        snippetJpaRepository.delete(snippet);
    }
}
