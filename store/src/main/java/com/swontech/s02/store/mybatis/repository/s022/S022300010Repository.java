/****************************************************
 * program : 비용진행현황 및 비용상세처리 (S022300010)
 * desc :
 * 1) 운영자, 회계 담당자가 비용요청 진행 전체 대상 List 조회
 * 2) 비용지급 처리 : 회계 담당자가 비용지급 처리 내용을 등록처리
 ****************************************************/
package com.swontech.s02.store.mybatis.repository.s022;

import com.swontech.s02.domain.dto.s022.S022300010Dto;
import com.swontech.s02.domain.store.s022.S022300010Store;
import com.swontech.s02.domain.vo.s022.S022300010Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S022300010Repository implements S022300010Store {
    private final SqlSessionTemplate sqlSessionTemplate;
    public S022300010Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    /*비용 요청 조회*/
    @Override
    public List<S022300010Dto.CostPayProTotList> selectCostPayProTotList(S022300010Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.selectList("S022300010.selectCostPayProTotList", paramsVo);
    }
    /*비용 요청 조회 상세*/
    @Override
    public S022300010Dto.CostPayProTotDetailHead selectCostPayProTotDetailHead(int eventUsedId) {
        return sqlSessionTemplate.selectOne("S022300010.selectCostPayProTotDetailHead", eventUsedId);
    }

    @Override
    public List<S022300010Dto.CostPayProTotDetailLine> selectCostPayProTotDetailLine(int eventUsedId) {
        return sqlSessionTemplate.selectList("S022300010.selectCostPayProTotDetailLine", eventUsedId);
    }

    /*비용지금 이력 등록*/
    @Override
    public int insertCostPayHistory(S022300010Vo.RegisterCostPayReqVo registerCostPayReqVo) {
        return sqlSessionTemplate.insert("S022300010.insertCostPayHistory", registerCostPayReqVo);
    }
    /*비용지금 진행상태 update */
    @Override
    public int updateCostPayProgressStatus(int eventUsedId) {
        return sqlSessionTemplate.update("S022300010.updateCostPayProgressStatus", eventUsedId);
    }

    @Override
    public List<S022300010Dto.ExcelCostPayTotalHead> excelCostPayTotalHead(S022300010Vo.ExcelParamsVo excelParamsVo) {
        return sqlSessionTemplate.selectList("S022300010.excelCostPayTotalHead", excelParamsVo);
    }

    @Override
    public List<S022300010Dto.ExcelCostPayTotalLine> excelCostPayTotalLine(S022300010Vo.ExcelParamsVo excelParamsVo) {
        return sqlSessionTemplate.selectList("S022300010.excelCostPayTotalLine", excelParamsVo);
    }

}
