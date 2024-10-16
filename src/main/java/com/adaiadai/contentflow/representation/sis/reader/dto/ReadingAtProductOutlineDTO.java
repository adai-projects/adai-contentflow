package com.adaiadai.contentflow.representation.sis.reader.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.sis.reader.ReadingAtProductOutlineBase;

import java.io.Serializable;

/**
 * ReadingAtProductOutlineDTO: 产品阅读概要[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReadingAtProductOutlineDTO extends ReadingAtProductOutlineBase implements Serializable {
    private static final long serialVersionUID = 1L;

    public ReadingAtProductOutlineDTO(Integer counterSum, String likePercent) {
        super(counterSum, likePercent);
    }

    public ReadingAtProductOutlineDTO() {
    }
}
