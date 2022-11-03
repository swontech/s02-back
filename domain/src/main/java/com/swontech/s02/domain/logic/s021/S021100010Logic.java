package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.s021.S021100010Spec;
import com.swontech.s02.domain.store.s021.S021100010Store;
import com.swontech.s02.domain.vo.s021.S021100010Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.swontech.s02.domain.dto.s021.S021100010Dto;

import java.util.List;

@Slf4j
public class S021100010Logic implements S021100010Spec {
    private final S021100010Store s021100010Store;
    private final CustomResponse response;
    public S021100010Logic(S021100010Store s021100010Store, CustomResponse response) {
        this.s021100010Store = s021100010Store;
        this.response = response;
    }


    @Override
    public ResponseEntity<?> retrieveOrgList(S021100010Dto.OrgListParamsDto reqDto) {
        return response.success(
                s021100010Store.selectOrgList(
                        S021100010Vo.SelectOrgListVo
                            .builder()
                                .orgName(reqDto.getOrgName())
                                .memberName(reqDto.getMemberName())
                                /*2022.11.02 kjy paging*/
                                .column(reqDto.getColumn())
                                .order(reqDto.getOrder())
                                .limit(reqDto.getLimit())
                                .curPage(reqDto.getCurPage())
                            .build()));
    }

    @Override
    public ResponseEntity<?> deleteOrgList(List<Integer> orgIdList) {
        int orgId = 0;
        try {
            for(int i: orgIdList) {
                orgId = i;
                s021100010Store.updateOrgStatus(i);
            }

            return response.success("데이터를 성공적으로 저장했습니다.");
        } catch (RuntimeException e) {
            log.error(e.getMessage());
            return response.fail("단체 번호 " + orgId + "를 저장하는 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
