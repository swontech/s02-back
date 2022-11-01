package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.vo.s021.S021100030Vo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S021100030Spec {
    ResponseEntity<?> selectMemberDetailInfo(int memberId);
    ResponseEntity<?> selectMemberList(S021100030Dto.RetriveMemberList reqDto);
    ResponseEntity<?> deleteMember(S021100030Dto.UpdateMemberTp reqDto);
    ResponseEntity<?> updateMember(S021100030Dto.UpdateMemberTp reqDto);

    /*2022.10.31 kjy 회원관리-업로드:일괄등록*/
    ResponseEntity<?> insertUploadMember(int orgId, int loginId, List<S021100030Dto.UploadMemberDto> uploadMemberDtoList);
}
