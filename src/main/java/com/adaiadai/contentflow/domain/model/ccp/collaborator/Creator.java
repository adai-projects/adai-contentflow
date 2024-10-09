package com.adaiadai.contentflow.domain.model.ccp.collaborator;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Creator extends AbstractCollaborator {
    private static final long serialVersionUID = 1L;

    public Creator(String identity) {
        super(identity);
    }

    protected Creator() {
        super();
    }
}
