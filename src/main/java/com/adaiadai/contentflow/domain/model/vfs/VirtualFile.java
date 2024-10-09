package com.adaiadai.contentflow.domain.model.vfs;

import com.adaiadai.contentflow.domain.model.IdentifiedEntityObject;

import javax.persistence.Embedded;

/**
 * @author amx
 */
public class VirtualFile extends IdentifiedEntityObject {
    private static final long serialVersionUID = 1L;

    @Embedded
    private VirtualFileId virtualFileId;
    private String path;
    private String name;
    private String type;
    private String content;
    private Long size;

    protected VirtualFile() {
        super();
    }

    public String path() {
        return this.path;
    }

    public VirtualFileId fileId() {
        return this.virtualFileId;
    }

    public void setVirtualFileId(VirtualFileId virtualFileId) {
        this.virtualFileId = virtualFileId;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String name() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String type() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String content() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long size() {
        return this.size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "VirtualFile{" +
                "virtualFileId=" + virtualFileId +
                ", path='" + path + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", content='" + content + '\'' +
                ", size=" + size +
                "} " + super.toString();
    }

}
