package com.adaiadai.contentflow.service.iaa;

import com.adaiadai.contentflow.representation.sis.tag.dto.TagItemDTO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service("iaaTagTranslator")
public class TagTranslator {

    public TagItemVO convertToItemVo(TagItemDTO tagItemDto) {
        if (tagItemDto != null) {
            TagItemVO tagItemVo = new TagItemVO();
            BeanUtils.copyProperties(tagItemDto, tagItemVo);
            return tagItemVo;
        } else {
            return null;
        }
    }
    public List<TagItemVO> convertToItemVo(List<TagItemDTO> tagItemDtoList) {
        List<TagItemVO> tagItemVoList = new ArrayList<>(tagItemDtoList.size());
        tagItemDtoList.forEach(tagItemDto -> tagItemVoList.add(this.convertToItemVo(tagItemDto)));
        return tagItemVoList;
    }
}
