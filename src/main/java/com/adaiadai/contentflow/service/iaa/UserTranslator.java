package com.adaiadai.contentflow.service.iaa;

import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.representation.iaa.UserBase;
import com.adaiadai.contentflow.representation.iaa.dto.UserCardDTO;
import com.adaiadai.contentflow.representation.iaa.vo.UserBaseVO;
import com.adaiadai.contentflow.representation.iaa.vo.UserCardVO;
import com.adaiadai.contentflow.representation.iaa.vo.UserDetailVO;
import com.adaiadai.contentflow.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adai
 */
@Service
public class UserTranslator {

    private UserBase convertToBase(User user) {
        UserBase userBase = new UserBase();
        userBase.setGmtCreate(user.gmtCreate());
        userBase.setGmtModified(user.gmtModified());
        userBase.setUserId(user.userId().id());
        userBase.setEmail(user.email());
        userBase.setUsername(user.username());
        userBase.setNickname(user.nickname());
        userBase.setAvatar(user.avatar());
        userBase.setWebsite(user.website());
        userBase.setNote(user.note());
        userBase.setNotice(user.notice());
        return userBase;
    }

    public UserDetailVO convetToDetailVo(User user) {
        UserDetailVO userDetailVo = new UserDetailVO(this.convertToBase(user));
        // 判断当前用户（包含已登录和未登录）是否是该用户主页的拥有着
        // 主人模式和访客模式：区别在于博客话题等是否可见
        boolean owned = SecurityUtil.isPrincipal(user.username());
        userDetailVo.setOwned(owned);
        return userDetailVo;
    }

    public List<UserCardDTO> convertToCardDto(List<User> userList) {
        List<UserCardDTO> userCardDtoList = new ArrayList<>(userList.size());
        userList.forEach(user -> userCardDtoList.add(new UserCardDTO(convertToBase(user))));
        return userCardDtoList;
    }

    public List<UserCardVO> convertToCardVo(List<User> userList) {
        List<UserCardVO> useCardVoList = new ArrayList<>(userList.size());
        userList.forEach(user -> useCardVoList.add(new UserCardVO(convertToBase(user))));
        return useCardVoList;
    }

    public UserBaseVO convertToBaseVo(User user) {
        return new UserBaseVO(convertToBase(user));
    }
}
