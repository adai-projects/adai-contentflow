package com.adaiadai.contentflow.representation.pmc.version.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import com.adaiadai.contentflow.representation.pmc.version.VersionBase;

/**
 * VersionBaseDTO: 版本基础[DTO]
 *
 * @author adai
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class VersionBaseVO extends VersionBase {

    public VersionBaseVO() {
    }

    public VersionBaseVO(VersionBase versionBase) {super(versionBase);}
}
