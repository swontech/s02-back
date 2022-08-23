package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s021.S021100070Spec;
import com.swontech.s02.domain.store.s021.S021100070Store;
import org.springframework.http.ResponseEntity;

public class S021100070Logic implements S021100070Spec {
    private final CustomResponse response;
    private final S021100070Store s021100070Store;
    public S021100070Logic(CustomResponse response, S021100070Store s021100070Store) {
        this.response = response;
        this.s021100070Store = s021100070Store;
    }

    @Override
    public ResponseEntity<?> retrieveDeptInfo(int eventId) {
        return response.success(s021100070Store.selectDeptDetailInfo(eventId));
    }

    @Override
    public ResponseEntity<?> retrieveDeptPayInfo(int eventId) {
        return response.success(s021100070Store.selectDeptDetailPayInfo(eventId));
    }
}
