package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100030Dto;
import org.springframework.http.ResponseEntity;

public interface S021100030Spec {
    ResponseEntity<?> selectMemberDetailInfo(int memberId);
    ResponseEntity<?> selectMemberList(S021100030Dto.RetriveMemberList reqDto);
    ResponseEntity<?> deleteMember(S021100030Dto.DeleteMember reqDto);
    ResponseEntity<?> updateMember(S021100030Dto.UpdateMemberTp reqDto);

}
