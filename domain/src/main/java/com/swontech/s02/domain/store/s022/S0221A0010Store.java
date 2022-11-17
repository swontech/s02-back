package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A0010Dto;
import com.swontech.s02.domain.vo.s022.S0221A0010Vo;

import java.util.List;

public interface S0221A0010Store {
    List<S0221A0010Dto.MobileInitUserInfo> selectMobileInitUserInfo(S0221A0010Vo.MobileInitUserInfoVo mobileInitUserInfoVo);
    List<S0221A0010Dto.MobileInitUseStateCnt> selectMobileInitUseStateCnt(S0221A0010Vo.MobileInitUseStateCntVo mobileInitUseStateCntVo);
    List<S0221A0010Dto.MobileInitPayCnt> selectMobileInitPayCnt(S0221A0010Vo.MobileInitPayCntVo mobileInitPayCntVo);
    List<S0221A0010Dto.MobileInitRecentEvent> selectMobileInitRecentEvent(S0221A0010Vo.MobileInitRecentEventVO mobileInitRecentEventVO);
    /*2022.11.09 kjy : 부서코드 검색 */
    List<S0221A0010Dto.SelectEventList> selectEventCode(S0221A0010Vo.SelectEventCodeVo selectEventCodeVo);
}
