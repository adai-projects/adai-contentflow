package com.adaiadai.contentflow.domain.model.sis.identity;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Operator extends AbstractIdentity {

    public Operator(String identity) {
        super(identity);
    }

    protected Operator() {
        super();
    }
}
