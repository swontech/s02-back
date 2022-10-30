package com.swontech.s02.domain.logic.comm;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.comm.CommonSpec;
import com.swontech.s02.domain.store.comm.CommonStore;
import com.swontech.s02.domain.vo.comm.CommonVo;
import org.springframework.http.ResponseEntity;

public class CommonLogic implements CommonSpec {
    private final CommonStore commonStore;
    private final CustomResponse response;
    public CommonLogic(CommonStore commonStore, CustomResponse response) {
        this.commonStore = commonStore;
        this.response = response;
    }

    @Override
    public ResponseEntity<?> retrieveCode(String category, String cdTp, Integer orgId, String cdV) {
        return response.success(
                commonStore.selectCodeList(
                    CommonVo.SelectCodeVo
                        .builder()
                            .category(category)
                            .cdTp(cdTp)
                            .orgId(orgId)
                            .cdV(cdV)
                        .build()
                    )
                );
    }
}
