package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S0221A2000Dto;
import com.swontech.s02.domain.vo.s022.S0221A2000Vo;

import java.util.List;

public interface S0221A2000Store {
    List<S0221A2000Dto.MoblieQRScanEventList> selectEventList(S0221A2000Vo.MoblieQRScanEventListVo moblieQRScanEventListVo);
}
