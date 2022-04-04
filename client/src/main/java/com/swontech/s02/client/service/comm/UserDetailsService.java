package com.swontech.s02.client.service.comm;

import com.swontech.s02.domain.logic.comm.UserDetailsLogic;
import com.swontech.s02.domain.store.s021.S021200010Store;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService extends UserDetailsLogic {
    public UserDetailsService(S021200010Store s021200010Store) {
        super(s021200010Store);
    }
}
