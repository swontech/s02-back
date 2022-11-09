package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S0221A0010Dto;
import com.swontech.s02.domain.spec.s022.S0221A0010Spec;
import com.swontech.s02.domain.store.s022.S0221A0010Store;
import com.swontech.s02.domain.vo.s022.S0221A0010Vo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class S0221A0010Logic implements S0221A0010Spec {
    private final S0221A0010Store s0221A0010Store;
    private final CustomResponse response;
    public S0221A0010Logic(S0221A0010Store s0221A0010Store, CustomResponse response) {
        this.s0221A0010Store = s0221A0010Store;
        this.response = response;
    }


    @Override
    public ResponseEntity<?> retrieveMobileInitUserInfo(String eventCode, String hpNo) {
        return response.success(s0221A0010Store.selectMobileInitUserInfo(S0221A0010Vo.MobileInitUserInfoVo.builder().eventCode(eventCode).hpNo(hpNo).build()));
    }

    @Override
    public ResponseEntity<?> retrieveMobileInitUseStateCnt(String eventCode, String hpNo) {
        return response.success(s0221A0010Store.selectMobileInitUseStateCnt(S0221A0010Vo.MobileInitUseStateCntVo.builder().eventCode(eventCode).hpNo(hpNo).build()));
    }

    @Override
    public ResponseEntity<?> retrieveMobileInitPayCnt(String eventCode, String hpNo) {
        return response.success(s0221A0010Store.selectMobileInitPayCnt(S0221A0010Vo.MobileInitPayCntVo.builder().eventCode(eventCode).hpNo(hpNo).build()));
    }

    @Override
    public ResponseEntity<?> retrieveMobileInitRecentEvent(int orgId, String eventCode) {
        return response.success(s0221A0010Store.selectMobileInitRecentEvent(S0221A0010Vo.MobileInitRecentEventVO.builder().orgId(orgId).eventCode(eventCode).build()));
    }
    /*2022.11.09 kjy : 부서코드 검색 */
    @Override
    public ResponseEntity<?> retrieveEventCode(S0221A0010Dto.SelectEventCodeParams params) {
        log.info("[S0221A0010] 부서코드 검색 : " + params);
        return response.success(s0221A0010Store.selectEventCode(
                                    S0221A0010Vo.SelectEventCodeVo.builder()
                                            .orgName(params.getOrgName())
                                            .ceoName(params.getCeoName())
                                            .memberName(params.getMemberName())
                                            .eventNm(params.getEventNm()).build()
                                ));
    }
}
