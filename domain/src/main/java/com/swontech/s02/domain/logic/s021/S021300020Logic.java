package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.spec.s021.S021300020Spec;
import com.swontech.s02.domain.store.S021300020Store;

public class S021300020Logic implements S021300020Spec {
    private final S021300020Store s021300020Store;
    public S021300020Logic(S021300020Store s021300020Store) {
        this.s021300020Store = s021300020Store;
    }
}
