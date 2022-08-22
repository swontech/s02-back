package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s021.S021100080Spec;
import com.swontech.s02.domain.store.s021.S021100080Store;
import com.swontech.s02.domain.vo.s021.S021100080Vo;
import org.springframework.http.ResponseEntity;

public class S021100080Logic implements S021100080Spec {
    private final CustomResponse response;
    private final S021100080Store s021100080Store;
    public S021100080Logic(CustomResponse response, S021100080Store s021100080Store) {
        this.response = response;
        this.s021100080Store = s021100080Store;
    }

    @Override
    public ResponseEntity<?> retrieveList(int orgId, String eventNm) {
        return response.success(
                s021100080Store.selectList(
                    S021100080Vo.SelectListVo
                        .builder()
                            .orgId(orgId)
                            .eventNm(eventNm)
                        .build()
                )
        );
    }
}
