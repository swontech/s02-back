package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.S021.S021100020Dto;

public interface S021100020Spec {
    /** 단체 등록 */
    public void registerOrg(S021100020Dto.RegisterOrg reqDto);

    /** 단체 상세 정보 수정 */
    public void patchOrgDetail();
}
