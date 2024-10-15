package com.adaiadai.contentflow.domain.model.ccp.collaborator;

import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public final class Blogger extends AbstractCollaborator {
    private static final long serialVersionUID = 1L;

    private String emailAddress;
    private String nickname;

    public Blogger(String identity) {
        super(identity);
    }

    protected Blogger() {
        super();
    }
}
