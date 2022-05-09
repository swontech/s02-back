package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.spec.s022.S0221A2000Spec;
import com.swontech.s02.domain.store.s022.S0221A2000Store;
import com.swontech.s02.domain.vo.s022.S0221A2000Vo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class S0221A2000Logic implements S0221A2000Spec {
    private final S0221A2000Store s0221A2000Store;
    private final ResponseDto response;
    public S0221A2000Logic(S0221A2000Store s0221A2000Store, ResponseDto response) {
        this.s0221A2000Store = s0221A2000Store;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveEventList(String eventName, String orgId) {
        return response.success(s0221A2000Store.selectEventList(S0221A2000Vo.SelectEventListVo
                .builder()
                        .eventName(eventName)
                        .orgId(orgId)
                .build()), "행사 목록이 성공적으로 조회되었습니다.", HttpStatus.OK);
    }
}
