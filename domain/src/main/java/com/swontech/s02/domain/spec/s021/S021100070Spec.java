package com.swontech.s02.domain.spec.s021;

import org.springframework.http.ResponseEntity;
import com.swontech.s02.domain.dto.s021.S021100070Dto;

import java.util.List;

public interface S021100070Spec {
    ResponseEntity<?> retrieveDeptLevel(int orgId);
    ResponseEntity<?> retrieveDeptInfo(int eventId);
    ResponseEntity<?> retrieveDeptPayInfo(int orgId, int eventId);

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

}
