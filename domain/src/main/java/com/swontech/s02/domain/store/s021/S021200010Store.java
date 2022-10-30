package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import com.swontech.s02.domain.vo.s021.S021200010Vo;

import java.util.Map;

public interface S021200010Store {
    S021200010Dto.MemberInfoDto selectMemberInfo(S021200010Vo.SelectMemberEmailVo selectMemberEmailVo);
    S021200010Vo.Member selectMember(String email);
    String selectEmail(S021200010Vo.SelectEmailVo selectEmailVo);
    int updatePwd(S021200010Vo.UpdatePwdVo updatePwdVo);
}
