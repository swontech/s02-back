package com.swontech.s02.domain.store.comm;

import com.swontech.s02.domain.dto.comm.CommonDto;
import com.swontech.s02.domain.vo.comm.CommonVo;

import java.util.List;

public interface CommonStore {
    List<CommonDto.SelectCodeResponse> selectCodeList(CommonVo.SelectCodeVo selectCodeVo);
}
