package com.swontech.s02.client.service.comm;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.logic.comm.CommonLogic;
import com.swontech.s02.domain.store.comm.CommonStore;
import org.springframework.stereotype.Service;

@Service
public class CommonService extends CommonLogic {
    public CommonService(CommonStore commonStore, CustomResponse response) {
        super(commonStore, response);
    }
}
