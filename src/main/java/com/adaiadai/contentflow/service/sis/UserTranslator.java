package com.adaiadai.contentflow.service.sis;

import com.adaiadai.contentflow.representation.iaa.dto.UserCardDTO;
import com.adaiadai.contentflow.representation.iaa.vo.UserCardVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service("sisUserTranslator")
public class UserTranslator {

    public List<UserCardVO> convertToCardVo(List<UserCardDTO> userCardDtoList) {
        List<UserCardVO> userCardVoList = new ArrayList<>(userCardDtoList.size());
        for (UserCardDTO userCardDTO : userCardDtoList) {
            UserCardVO userCardVo = new UserCardVO();
            BeanUtils.copyProperties(userCardDTO, userCardVo);
            userCardVoList.add(userCardVo);
        }
        return userCardVoList;
    }
}
