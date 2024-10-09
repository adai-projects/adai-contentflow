package com.adaiadai.contentflow.application.iaa;

import com.adaiadai.contentflow.application.pmc.ProjectApplicationService;
import com.adaiadai.contentflow.application.sis.TagApplicationService;
import com.adaiadai.contentflow.constant.ccp.ScopeConstant;
import com.adaiadai.contentflow.constant.iaa.UserEnum;
import com.adaiadai.contentflow.constant.iaa.UserExceptionEnum;
import com.adaiadai.contentflow.domain.model.iaa.User;
import com.adaiadai.contentflow.exception.NotFoundException;
import com.adaiadai.contentflow.representation.iaa.dto.UserCardDTO;
import com.adaiadai.contentflow.representation.iaa.form.UserCreateForm;
import com.adaiadai.contentflow.representation.iaa.form.UserModifyForm;
import com.adaiadai.contentflow.representation.iaa.vo.UserBaseVO;
import com.adaiadai.contentflow.representation.iaa.vo.UserCardVO;
import com.adaiadai.contentflow.representation.iaa.vo.UserDetailVO;
import com.adaiadai.contentflow.representation.pmc.project.dto.ProjectItemDTO;
import com.adaiadai.contentflow.representation.pmc.project.vo.ProjectItemVO;
import com.adaiadai.contentflow.representation.sis.tag.dto.TagItemDTO;
import com.adaiadai.contentflow.representation.sis.tag.vo.TagItemVO;
import com.adaiadai.contentflow.service.iaa.ProjectTranslator;
import com.adaiadai.contentflow.service.iaa.TagTranslator;
import com.adaiadai.contentflow.service.iaa.UserService;
import com.adaiadai.contentflow.service.iaa.UserTranslator;
import com.adaiadai.contentflow.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author adai
 */
@Service
public class UserApplicationService {

    @Autowired
    private ProjectApplicationService projectApplicationService;
    @Autowired
    private TagApplicationService tagApplicationService;

    @Autowired
    private UserService userService;
    @Autowired
    private UserTranslator userTranslator;
    @Autowired
    private ProjectTranslator projectTranslator;
    @Autowired
    private TagTranslator tagTranslator;

    public User getByUserId(String userId) {
        return null;
    }

    public UserModifyForm getModifyFormByUserId(String userId) {
        return null;
    }

    public UserDetailVO getDetailVoByUsername(String username) {
        User byUsername = userService.getByUsername(username);
        if (byUsername != null) {
            return userTranslator.convetToDetailVo(byUsername);
        } else {
            throw new NotFoundException(UserExceptionEnum.USER_ON_ABSENT.getMessage());
        }
    }

    public List<User> list() {
        return null;
    }

    public List<UserCardVO> listCardVo() {
        List<User> userList = userService.selectAll();
        // 用户过滤
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            Collection<? extends GrantedAuthority> authorities = user.authorities();
            boolean isDeleted = false;
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().contains(UserEnum.USER_AUTHORITY_ROOT.getAuthority())) {
                    // 有且仅有一个管理员用户，移除即可
                    iterator.remove();
                    isDeleted = true;
                    break;
                }
            }
            if (isDeleted) {
                break;
            }
        }
        return userTranslator.convertToCardVo(userList);
    }

    public List<UserCardDTO> listCardByIdentities(List<String> identities) {
        if (identities != null && identities.size() > 0) {
            List<User> userList = new ArrayList<>(identities.size());
            identities.forEach(identity -> userList.add(userService.getByUsername(identity)));
            return userTranslator.convertToCardDto(userList);
        } else {
            return null;
        }
    }

    public List<ProjectItemVO> listProjectItemVoByUsername(String username) {
        boolean owned = SecurityUtil.isPrincipal(username);
        List<ProjectItemDTO> projectItemDtoList;
        if (owned) {
            projectItemDtoList = projectApplicationService.listItemByIdentity(username);
        } else {
            projectItemDtoList = projectApplicationService.listItemByIdentityAndScope(username, ScopeConstant.SCOPE_PUBLIC);
        }
        return projectItemDtoList.isEmpty() ? null : projectTranslator.convertToItemVo(projectItemDtoList);
    }

    public List<TagItemVO> listTagItemVoByUsername(String username) {
        List<TagItemDTO> tagItemDtoList = tagApplicationService.listItemByIdentity(username);
        if (tagItemDtoList != null && tagItemDtoList.size() >0) {
            return tagTranslator.convertToItemVo(tagItemDtoList);
        } else {
            return null;
        }
    }

    public User post(UserCreateForm userCreateForm) {
        return userService.insert(userCreateForm);
    }

    public User updateByUserId(String userId, UserModifyForm userModifyForm) {
        return null;
    }

    public void deleteByUserId(String userId) {

    }

    public UserBaseVO getUserBaseVo() {
        return userTranslator.convertToBaseVo(userService.principal());
    }
}
