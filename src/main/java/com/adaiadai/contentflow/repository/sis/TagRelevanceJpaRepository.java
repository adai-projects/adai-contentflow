package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.tag.TagRelevance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface TagRelevanceJpaRepository extends JpaRepository<TagRelevance, Long> {

    /**
     * 查找所有标签关联，通过标签名称
     *
     * @param tagName 标签名称
     * @return 标签关联集合
     */
    List<TagRelevance> findAllByTagsContaining(String tagName);
}
