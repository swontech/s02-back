package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0030Dto;
import com.swontech.s02.domain.vo.s022.S0221A0030Vo;

public interface S0221A0030Store {
    String selectMemberId(String hpNo);

    int updateMobileId(S0221A0030Vo.UpdateMobileIdVo updateMobileIdVo);

    int insertMemberInfo(S0221A0030Vo.InsertMemberInfoVo vo);

    S0221A0030Dto.SignUpResponse selectSignUpInfo(String hpNo);
}
