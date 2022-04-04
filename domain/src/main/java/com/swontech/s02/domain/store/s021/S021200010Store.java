package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.vo.s021.S021200010Vo;

public interface S021200010Store {
    String selectMemberEmail(S021200010Vo.SelectMemberEmailVo selectMemberEmailVo);

    S021200010Vo.Member selectMember(String email);
}
