package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.vo.s021.S021100020Vo;

public interface S021100020Store {
    int registerOrg(S021100020Vo.InsertOrgVo insertOrgVo);

    int registerMember(S021100020Vo.InsertMemberVo insertMemberVo);

}
