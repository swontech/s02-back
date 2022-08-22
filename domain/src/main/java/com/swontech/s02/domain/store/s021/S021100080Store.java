package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100080Dto;
import com.swontech.s02.domain.vo.s021.S021100080Vo;

import java.util.List;

public interface S021100080Store {
    List<S021100080Dto.SelectListResponse> selectList(S021100080Vo.SelectListVo selectListVo);
}
