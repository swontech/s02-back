package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s021.S021100050Spec;
import com.swontech.s02.domain.store.s021.S021100050Store;
import com.swontech.s02.domain.vo.s021.S021100050Vo;
import org.springframework.http.ResponseEntity;

public class S021100050Logic implements S021100050Spec {
    private final S021100050Store s021100050Store;
    private final CustomResponse response;
    public S021100050Logic(S021100050Store s021100050Store, CustomResponse response) {
        this.s021100050Store = s021100050Store;
        this.response = response;
    }


    @Override
    public ResponseEntity<?> retrieveMemberList(int orgId, String memberName) {
        return response.success(s021100050Store.selectMemberList(
                                    S021100050Vo.SelectMemberListVo
                                        .builder()
                                            .orgId(orgId)
                                            .memberName(memberName)
                                        .build()
                                )
        );
    }
}
