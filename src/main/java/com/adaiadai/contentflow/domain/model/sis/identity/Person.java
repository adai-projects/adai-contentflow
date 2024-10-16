package com.adaiadai.contentflow.domain.model.sis.identity;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Person extends AbstractIdentity {
    private static final long serialVersionUID = 1L;

    public Person(String identity) {
        super(identity);
    }

    protected Person() {
        super();
    }

}
