package com.adaiadai.contentflow.representation.ccp.snippet.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.ccp.snippet.SnippetBase;

import java.util.Date;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SnippetBaseVO extends SnippetBase {

    public SnippetBaseVO(String snippetId
            , String creatorIdentity
            , String title
            , String description
            , String content
            , String contentHtml
            , Date gmtCreate
            , Date gmtModified) {
        super(snippetId, creatorIdentity, title, description, content, contentHtml, gmtCreate, gmtModified);
    }

    public SnippetBaseVO() {
    }
}
