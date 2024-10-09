package com.adaiadai.contentflow.service.ccp;

import com.adaiadai.contentflow.constant.ccp.ScopeConstant;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetId;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * SnippetService: 片段接口
 *
 * @author adai
 */
@Service
public class SnippetService {

    @Autowired
    private SnippetRepository snippetRepository;

    public SnippetId nextIdentity() {
        return snippetRepository.nextIdentity();
    }

    public Snippet getBySnippetId(SnippetId snippetId) {
        return snippetRepository.snippetOfSnippetId(snippetId);
    }

    public void add(Snippet snippet) {
        snippetRepository.add(snippet);
    }

    public void update(Snippet snippet) {
        snippetRepository.add(snippet);
    }

    public void deleteBySnippetId(SnippetId snippetId) {
        snippetRepository.remove(snippetRepository.snippetOfSnippetId(snippetId));
    }

    public List<Snippet> listPublicSnippets() {
        return (List<Snippet>) snippetRepository.snippetsOfScope(ScopeConstant.SCOPE_PUBLIC);
    }
}
