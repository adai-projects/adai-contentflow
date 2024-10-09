package com.adaiadai.contentflow.representation.ccp.blog.vo;

import lombok.Getter;
import lombok.ToString;

/**
 * @param <T>
 * @author adai
 */
@Getter
@ToString
public class BlogVO<T extends BlogBaseVO> {

    private T t;

    public BlogVO(T t) {
        this.t = t;
    }
}
