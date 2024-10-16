package com.adaiadai.contentflow.repository.sis;

import com.adaiadai.contentflow.domain.model.sis.identity.Person;
import com.adaiadai.contentflow.domain.model.sis.tag.PersonTag;
import com.adaiadai.contentflow.domain.model.sis.tag.PersonTagRepository;
import com.adaiadai.contentflow.domain.model.sis.tag.TagId;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author adai
 */
@Component
public class HibernatePersonTagRepository implements PersonTagRepository {

    private final PersonTagJpaRepository personTagJpaRepository;

    public HibernatePersonTagRepository(PersonTagJpaRepository personTagJpaRepository) {
        this.personTagJpaRepository = personTagJpaRepository;
    }

    @Override
    public PersonTag personTagOfPersonAndTagId(Person person, TagId tagId) {
        return personTagJpaRepository.findByTagIdAndPerson(tagId, person);
    }

    @Override
    public Collection<PersonTag> personTagsOfTagId(TagId tagId) {
        return personTagJpaRepository.findAllByTagId(tagId);
    }

    @Override
    public Collection<PersonTag> personTagsOfPerson(Person person) {
        return personTagJpaRepository.findAllByPerson(person);
    }

    @Override
    public void add(PersonTag personTag) {
        personTagJpaRepository.save(personTag);
    }

    @Override
    public void remove(PersonTag personTag) {
        personTagJpaRepository.delete(personTag);
    }
}
