package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0030Dto;
import com.swontech.s02.domain.vo.s021.S021100030Vo;
import com.swontech.s02.domain.vo.s022.S0221A0030Vo;

public interface S0221A0030Store {
    S0221A0030Dto.MobileMemberExistFlag selectMemberExistFlag(S0221A0030Vo.SelectMemberExistFlagVo selectMemberExistFlagVo);
    int insertNewMobileMember(S0221A0030Vo.InsertNewMobileMemberVo insertNewMobileMemberVo);
    int insertNewMobileEventMember(S0221A0030Vo.InsertNewMobileEventMemberVo insertNewMobileEventMemberVo);
    int updateMobileId(S0221A0030Vo.UpdateMobileIdVo updateMobileIdVo);
    int updateMobileMember(S0221A0030Vo.UpdateMobileMemberVo updateMobileMemberVo);
    S0221A0030Dto.SignUpResponse selectSignUpInfo(String hpNo);
}
