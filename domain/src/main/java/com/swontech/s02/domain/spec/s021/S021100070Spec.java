package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;
import com.swontech.s02.domain.dto.s021.S021100070Dto;

import java.util.List;

public interface S021100070Spec {
    ResponseEntity<?> retrieveDeptLevel(int orgId);
    ResponseEntity<?> retrieveDeptInfo(int eventId);
    ResponseEntity<?> retrieveDeptPayInfo(int orgId, int eventId);

    /** kjy 부서(행사) 신규 등록(최상위)인 경우 신규생성 발번된 부서코드 조회 */
    ResponseEntity<?> retrieveNewEventCode(int orgId, int eventId);

    /** 부서(행사) 신규 등록 */
    ResponseEntity<?> registerEvent(S021100070Dto.RegisterEventDto registerEventDto );

    /** 부서(행사)단위 회원 등록 */
    ResponseEntity<?> registerEventMember(int eventId, List<S021100070Dto.RegisterEventMemberDto> litRegEventMemberDto );

    /** 부서(행사) 수정 */
    ResponseEntity<?> patchEvent(S021100070Dto.PatchEventDto patchEventDto );

    /** 부서(행사) 저장 : 화면에서 저장버튼 기능 */
    ResponseEntity<?> saveEvent(int eventId,
                                S021100070Dto.RegisterEventDto registerEventDto,
                                List<S021100070Dto.RegisterEventMemberDto> litRegEventMemberDto );
    /*행사최하위여부( EVENT_FINAL_FLAG) null update */
    ResponseEntity<?> patchEventFinalFlag(int orgId, int eventId);
    /* 기본사역 삭제 처리 update  */
    ResponseEntity<?> patchDefaultEventFlag(int orgId, int eventId);
}
