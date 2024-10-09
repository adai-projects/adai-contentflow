package com.adaiadai.contentflow.domain.model.sis.tag;

import com.adaiadai.contentflow.domain.model.sis.identity.Creator;

import java.util.Collection;

/**
 * @author adai
 */
public interface PersonTagGatherRepository {

    PersonTagGather personTagGatherOfNameAndCreator(String name, Creator creator);

    Collection<PersonTagGather> personTagGathersOfCreator(Creator creator);
}
