package com.adaiadai.contentflow.representation;

import lombok.Data;

/**
 * ResultVO: 结果[VO]
 *
 * @author adai
 */
@Data
public class ResultVO {

    private Boolean valid;
    private Integer code;
    private String message;
    private Object data;
}
