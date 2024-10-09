package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Creator;
import com.adaiadai.contentflow.domain.model.sis.tag.PersonTagGather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author adai
 */
@Repository
public interface PersonTagGatherJpaRepository extends JpaRepository<PersonTagGather, Long> {

    PersonTagGather findByNameAndCreator(String name, Creator creator);

    List<PersonTagGather> findAllByCreator(Creator creator);
}
