package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100020Dto;
import com.swontech.s02.domain.vo.s021.S021100020Vo;

public interface S021100020Store {
    String selectMemberEmail(String email);

    int insertOrg(S021100020Vo.InsertOrgVo insertOrgVo);

    int insertMember(S021100020Vo.InsertMemberVo insertMemberVo);

    S021100020Dto.OrgDetailInfo selectOrg(int orgId);

    int updateOrg(S021100020Vo.UpdateOrgVo updateOrg);

}
