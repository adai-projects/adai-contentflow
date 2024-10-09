package com.adaiadai.contentflow.domain.model.sis.identity;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Commenter extends AbstractIdentity {
    private static final long serialVersionUID = 1L;

    public Commenter(String identity) {
        super(identity);
    }

    protected Commenter () {
        super();
    }
}
