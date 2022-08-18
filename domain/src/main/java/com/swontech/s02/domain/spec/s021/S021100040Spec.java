package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100040Dto;
import org.springframework.http.ResponseEntity;

public interface S021100040Spec {
    ResponseEntity<?> registerMember(S021100040Dto.RegisterMemberDto reqDto);
    ResponseEntity<?> updateMemberInfo(S021100040Dto.UpdateMemberInfoDto reqDto);
}
