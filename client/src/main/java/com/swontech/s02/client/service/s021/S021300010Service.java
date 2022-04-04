package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.logic.s021.S021300010Logic;
import com.swontech.s02.domain.store.s021.S021300010Store;
import org.springframework.stereotype.Service;

@Service
public class S021300010Service extends S021300010Logic {
    public S021300010Service(S021300010Store s021300010Store) {
        super(s021300010Store);
    }
}
