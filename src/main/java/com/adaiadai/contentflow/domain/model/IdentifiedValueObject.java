package com.adaiadai.contentflow.domain.model;

import javax.persistence.*;

/**
 * @author adai
 */
@MappedSuperclass
public class IdentifiedValueObject extends IdentifiedDomainObject {
    private static final long serialVersionUID = 1L;

    public IdentifiedValueObject(Long id) {
        super(id);
    }

    protected IdentifiedValueObject() {
        super();
    }

}
