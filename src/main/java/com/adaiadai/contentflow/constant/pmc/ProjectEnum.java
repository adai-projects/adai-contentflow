package com.adaiadai.contentflow.constant.pmc;

import lombok.Getter;

/**
 * TopicEnum: 话题枚举
 *
 * @author adai
 */
@Getter
public enum ProjectEnum {
    /**
     * ROOT: 根话题
     */
    TOPIC_ROOT("ROOT", "ROOT");

    /**
     * name: 名称
     */
    private String name;

    /**
     * description: 描述
     */
    private String description;

    ProjectEnum(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
