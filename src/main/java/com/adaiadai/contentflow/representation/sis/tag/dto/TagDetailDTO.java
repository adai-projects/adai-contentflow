package com.adaiadai.contentflow.representation.sis.tag.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.domain.model.sis.tag.Tag;
import org.springframework.beans.BeanUtils;

import java.util.List;

/**
 * TagDetailDTO: 标签详情数据传输对象[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TagDetailDTO extends TagBaseDTO {

    /**
     * tagRelevantDtoList: 标签关联数据传输对象集合
     */
    private List<TagRelevantDTO> tagRelevantDtoList;

    public TagDetailDTO(Tag tag) {
        BeanUtils.copyProperties(tag, this);
    }
}
