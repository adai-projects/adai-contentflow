package com.adaiadai.contentflow.domain.model.sis.identity;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Reader extends AbstractIdentity {
    private static final long serialVersionUID = 1L;

    public Reader(String identity) {
        super(identity);
    }

    protected Reader() {
        super();
    }
}
