package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100020Dto;
import org.springframework.http.ResponseEntity;

public interface S021100020Spec {
    /** 이메일 중복 체크 */
    ResponseEntity<?> duplicationCheckEmail(String email);
    /** 단체 등록 */
    ResponseEntity<?> registerOrg(S021100020Dto.RegisterOrg reqDto);
    /** 단체 상세정보 조회 */
    ResponseEntity<?> retrieveOrg(int orgId);
    /** 단체 상세 정보 수정 */
    ResponseEntity<?> patchOrgDetail(S021100020Dto.PatchOrg reqDto);
}
