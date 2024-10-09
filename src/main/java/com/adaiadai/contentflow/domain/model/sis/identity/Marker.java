package com.adaiadai.contentflow.domain.model.sis.identity;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Marker extends AbstractIdentity {

    public Marker(String identity) {
        super(identity);
    }

    protected Marker() {
        super();
    }

}
