package com.adaiadai.contentflow.service.ccp.translator;

import com.adaiadai.contentflow.representation.sis.tag.dto.TagAtProductDTO;
import com.adaiadai.contentflow.representation.sis.tag.dto.TagItemDTO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagAtProductVO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service("ccpTagTranslator")
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

    public List<TagItemVO> convertToItemVo(List<TagItemDTO> tagItemDtos) {
        List<TagItemVO> tagItemVos = new ArrayList<>(tagItemDtos.size());
        tagItemDtos.forEach(tagItemDto -> tagItemVos.add(this.convertToItemVo(tagItemDto)));
        return tagItemVos;
    }

    public TagAtProductVO convertToTagAtProductVo(TagAtProductDTO tagAtProductDTO) {
        TagAtProductVO tagAtProductVO = new TagAtProductVO();
        BeanUtils.copyProperties(tagAtProductDTO, tagAtProductVO);
        return tagAtProductVO;
    }

    public List<TagAtProductVO> convertToTagAtProductVo(List<TagAtProductDTO> tagAtProductDtoList) {
        List<TagAtProductVO> tagAtProductVoList = new ArrayList<>();
        tagAtProductDtoList.forEach(tagAtProductDTO -> tagAtProductVoList.add(this.convertToTagAtProductVo(tagAtProductDTO)));
        return tagAtProductVoList;
    }
}
