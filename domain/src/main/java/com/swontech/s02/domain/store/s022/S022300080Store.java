package com.swontech.s02.domain.store.s022;

import com.swontech.s02.domain.dto.s022.S022300080Dto;
import com.swontech.s02.domain.vo.s022.S022300080Vo;

import java.util.List;

public interface S022300080Store {
    List<S022300080Dto.RetrieveAttendList> selectEnterList(S022300080Vo.SelectEnterListVo selectEnterListVo);

    int insertEnter(List<S022300080Vo.InsertEnterVo> insertEnterVo);

    int deleteEnter(List<S022300080Vo.DeleteEnterVo> deleteEnterVo);

    List<S022300080Dto.SelectEventLov> selectEventLov(int orgId);
}
