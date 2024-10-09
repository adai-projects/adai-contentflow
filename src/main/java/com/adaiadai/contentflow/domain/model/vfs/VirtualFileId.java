package com.adaiadai.contentflow.domain.model.vfs;

import com.adaiadai.contentflow.domain.model.AbstractValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author adai
 */
@Embeddable
public class VirtualFileId extends AbstractValueObject {
    private static final long serialVersionUID = 1L;

    @Column(name = "virtual_file_id_id")
    private String id;

    public VirtualFileId(String id) {
        this();
        this.setId(id);
    }

    protected VirtualFileId() {
        super();
    }

    public String id() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VirtualFileId{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
