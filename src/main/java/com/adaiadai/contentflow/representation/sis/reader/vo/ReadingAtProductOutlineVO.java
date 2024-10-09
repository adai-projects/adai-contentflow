package com.adaiadai.contentflow.representation.sis.reader.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.reader.ReadingAtProductOutlineBase;

/**
 * ReadingAtProductOutlineVO: 产品阅读概要[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReadingAtProductOutlineVO extends ReadingAtProductOutlineBase {

    public ReadingAtProductOutlineVO(Integer counterSum, String likePercent) {
        super(counterSum, likePercent);
    }

    public ReadingAtProductOutlineVO() {
    }

}
