package com.adaiadai.contentflow.repository.ccp;

import com.adaiadai.contentflow.domain.model.ccp.collaborator.Creator;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import com.adaiadai.contentflow.domain.model.ccp.product.snippet.SnippetId;
import com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetCardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * SnippetRepository: 片段仓库
 *
 * @author adai
 */
@Repository
public interface SnippetJpaRepository extends JpaRepository<Snippet, Long> {

    Snippet findBySnippetId(SnippetId snippetId);

    List<Snippet> findAllByScope(Integer nonPrivate);

    List<Snippet> findAllByScopeAndCreator(Integer scope, Creator creator);

    List<Snippet> findAllByCreator(Creator creator);

    @Query(value = "select new com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetCardVO(s.snippetId.id as snippetId" +
            ", s.creator.identity as creatorIdentity" +
            ", s.title as title" +
            ", s.description as description" +
            ", s.content as content" +
            ", s.contentHtml as contentHtml" +
            ", s.gmtCreate as gmtCreate" +
            ", s.gmtModified as gmtModified) " +
            "from Snippet s where scope=:scope")
    Page<SnippetCardVO> findAllByScope(@Param("scope") Integer scope, Pageable pageable);

    @Query(value = "select new com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetCardVO(s.snippetId.id as snippetId" +
            ", s.creator.identity as creatorIdentity" +
            ", s.title as title" +
            ", s.description as description" +
            ", s.content as content" +
            ", s.contentHtml as contentHtml" +
            ", s.gmtCreate as gmtCreate" +
            ", s.gmtModified as gmtModified ) " +
            "from Snippet s " +
            "where (s.title like concat('%', :title, '%') or s.description like concat('%', :description ,'%'))" +
            "and s.scope = :scope")
    Page<SnippetCardVO> findAllByTitleContainingOrDescriptionContainingAndScope(@Param("title") String title
            , @Param("description") String description
            , @Param("scope") Integer scope
            , Pageable pageable);
}
