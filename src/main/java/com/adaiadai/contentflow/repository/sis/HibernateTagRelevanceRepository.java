package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.tag.TagRelevance;
import com.adaiadai.contentflow.domain.model.sis.tag.TagRelevanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author adai
 */
@Repository
public class HibernateTagRelevanceRepository implements TagRelevanceRepository {

    @Autowired
    private TagRelevanceJpaRepository tagRelevanceJpaRepository;

    @Override
    public void add(TagRelevance tagRelevance) {
        tagRelevanceJpaRepository.save(tagRelevance);
    }
}
