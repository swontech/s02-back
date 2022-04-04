package com.swontech.s02.client.service.s021;

import com.swontech.s02.domain.logic.s021.S021300020Logic;
import com.swontech.s02.domain.store.s021.S021300020Store;
import org.springframework.stereotype.Service;

@Service
public class S021300020Service extends S021300020Logic {
    public S021300020Service(S021300020Store s021300020Store) {
        super(s021300020Store);
    }
}
