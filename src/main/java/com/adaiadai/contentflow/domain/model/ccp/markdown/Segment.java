package com.adaiadai.contentflow.domain.model.ccp.markdown;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.domain.model.AbstractValueObject;

/**
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Segment extends AbstractValueObject {

    private String content;
    private String title;
    private Integer level;
    private Integer index;

}
