package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s021.S021100060Spec;
import com.swontech.s02.domain.store.s021.S021100060Store;

public class S021100060Logic implements S021100060Spec {
    private final CustomResponse response;
    private final S021100060Store s021100060Store;
    public S021100060Logic(CustomResponse response, S021100060Store s021100060Store) {
        this.response = response;
        this.s021100060Store = s021100060Store;
    }
}
