package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100070Dto;
import com.swontech.s02.domain.vo.s021.S021100070Vo;

import java.util.List;

public interface S021100070Store {
    List<S021100070Dto.DeptLevel> selectDeptLevel(int orgId);
    S021100070Dto.DeptDetailInfo selectDeptDetailInfo(int eventId);
    List<S021100070Dto.DeptDetailPayInfo> selectDeptDetailPayInfo(S021100070Vo.ParamsVo paramsVo);
}
