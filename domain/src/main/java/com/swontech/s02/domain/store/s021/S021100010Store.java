package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100010Dto;
import com.swontech.s02.domain.vo.s021.S021100010Vo;

import java.util.List;

public interface S021100010Store {
    List<S021100010Dto.OrgListResponse> selectOrgList(S021100010Vo.SelectOrgListVo selectOrgListVo);
    int updateOrgStatus(int orgIdList);
}
