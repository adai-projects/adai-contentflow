package com.adaiadai.contentflow.representation.pmc.version.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.version.VersionBase;

/**
 * VersionItemVO: 版本条目[VO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VersionItemVO extends VersionBaseVO {

    public VersionItemVO(VersionBase versionBase) {super(versionBase);}
}
