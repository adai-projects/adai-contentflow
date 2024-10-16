package com.adaiadai.contentflow.service.ccp;

import com.adaiadai.contentflow.domain.model.ccp.product.snippet.Snippet;
import com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetBaseVO;
import com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetDetailVO;
import com.adaiadai.contentflow.representation.ccp.snippet.vo.SnippetModifyForm;
import com.adaiadai.contentflow.util.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @author adai
 */
@Service
public class SnippetTranslator {

    public SnippetBaseVO convertToBaseVo(Snippet snippet) {
        SnippetBaseVO baseVo = new SnippetBaseVO();
        baseVo.setSnippetId(snippet.snippetId().id());
        baseVo.setCreatorIdentity(snippet.creator().identify());
        baseVo.setTitle(snippet.title());
        baseVo.setDescription(snippet.description());
        baseVo.setContent(snippet.content());
        baseVo.setContentHtml(snippet.contentHtml());
        baseVo.setGmtCreate(snippet.gmtCreate());
        baseVo.setGmtModified(snippet.gmtModified());
        return baseVo;
    }

    public SnippetDetailVO convertToDetailVo(Snippet snippet) {
        if (snippet != null) {
            SnippetDetailVO snippetDetailVo = new SnippetDetailVO();
            BeanUtils.copyProperties(this.convertToBaseVo(snippet), snippetDetailVo);
            if (SecurityUtil.isPrincipal(snippet.creator().identify())) {
                snippetDetailVo.setHasAccess(true);
            } else {
                snippetDetailVo.setHasAccess(false);
            }
            return snippetDetailVo;
        } else {
            return null;
        }

    }

    public SnippetModifyForm convertToModifyVo(Snippet snippet) {
        if (snippet != null) {
            SnippetModifyForm modifyVo = new SnippetModifyForm();
            modifyVo.setTitle(snippet.title());
            modifyVo.setContent(snippet.content());
            modifyVo.setContentHtml(snippet.contentHtml());
            modifyVo.setDescription(snippet.description());
            return modifyVo;
        } else {
            return null;
        }
    }
}
