package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S0221A0010Dto;
import com.swontech.s02.domain.store.s022.S0221A0010Store;
import com.swontech.s02.domain.vo.s022.S0221A0010Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S0221A0010Repository implements S0221A0010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S0221A0010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }


    @Override
    public List<S0221A0010Dto.MobileInitUserInfo> selectMobileInitUserInfo(S0221A0010Vo.MobileInitUserInfoVo mobileInitUserInfoVo) {
        return sqlSessionTemplate.selectList("S0221A0010.mobileInitUserInfo", mobileInitUserInfoVo);
    }

    @Override
    public List<S0221A0010Dto.MobileInitUseStateCnt> selectMobileInitUseStateCnt(S0221A0010Vo.MobileInitUseStateCntVo mobileInitUseStateCntVo) {
        return sqlSessionTemplate.selectList("S0221A0010.mobileInitUseStateCnt", mobileInitUseStateCntVo);
    }

    @Override
    public List<S0221A0010Dto.MobileInitPayCnt> selectMobileInitPayCnt(S0221A0010Vo.MobileInitPayCntVo mobileInitPayCntVo) {
        return sqlSessionTemplate.selectList("S0221A0010.mobileInitPayCnt", mobileInitPayCntVo);
    }

    @Override
    public List<S0221A0010Dto.MobileInitRecentEvent> selectMobileInitRecentEvent(S0221A0010Vo.MobileInitRecentEventVO mobileInitRecentEventVO) {
        return sqlSessionTemplate.selectList("S0221A0010.mobileInitRecentEvent", mobileInitRecentEventVO);
    }
}
