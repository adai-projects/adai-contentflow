package com.adaiadai.contentflow.representation.sis.reader;

import lombok.Data;

/**
 * @author adai
 */
@Data
public class ReadingBase {

    private String productId;
    private String productType;
    private String readerIdentity;
    private Integer liked;
    private Integer disliked;
    private Integer counter;
}
