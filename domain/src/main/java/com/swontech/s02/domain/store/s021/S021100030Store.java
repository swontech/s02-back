package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.dto.s022.S0221A0030Dto;
import com.swontech.s02.domain.vo.s021.S021100030Vo;

import java.util.List;

public interface S021100030Store {
    List<S021100030Dto.MemberListResponse> selectMemberList(S021100030Vo.SelectMemberListVo selectMemberListVo);
    S021100030Dto.MemberDetailInfo selectMemberDetailInfo(int memberId);
    int deleteMember(S021100030Vo.UpdateMemberTp updateMemberTpVo);
    int updateMemberTp(S021100030Vo.UpdateMemberTp updateMemberTpVo);
    String getPayerFlag(int memberId);

    /*2022.10.31 kjy 회원관리-업로드:일괄등록*/
    int insertUploadMember(S021100030Vo.UploadMemberVo uploadMemberVo);
}
