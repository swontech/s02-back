package com.swontech.s02.domain.logic.s021;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s021.S021100030Dto;
import com.swontech.s02.domain.spec.s021.S021100030Spec;
import com.swontech.s02.domain.store.s021.S021100030Store;
import com.swontech.s02.domain.vo.s021.S021100030Vo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class S021100030Logic implements S021100030Spec {
    private final CustomResponse response;
    private final S021100030Store s021100030Store;
    private final Logger logger = LoggerFactory.getLogger(S021100030Logic.class);

    public S021100030Logic(CustomResponse response, S021100030Store s021100030Store) {
        this.response = response;
        this.s021100030Store = s021100030Store;
    }

    @Override
    public ResponseEntity<?> selectMemberDetailInfo(int memberId) {
        return response.success(s021100030Store.selectMemberDetailInfo(memberId));
    }

    @Override
    public ResponseEntity<?> selectMemberList(S021100030Dto.RetriveMemberList reqDto) {
        return response.success(s021100030Store.selectMemberList(
                S021100030Vo.SelectMemberListVo
                        .builder()
                            .orgId(reqDto.getOrgId())
                            .fromDt(reqDto.getFromDt())
                            .toDt(reqDto.getToDt())
                            .memberTp(reqDto.getMemberTp())
                            .memberName(reqDto.getMemberName())
                            /*2022.11.01 kjy paging*/
                            .column(reqDto.getColumn())
                            .order(reqDto.getOrder())
                            .limit(reqDto.getLimit())
                            .curPage(reqDto.getCurPage())
                        .build()
                )
        );
    }

    @Override
    public ResponseEntity<?> deleteMember(S021100030Dto.UpdateMemberTp reqDto) {
        try {
            String returnMessage = s021100030Store.getPayerFlag(reqDto.getMemberId());

            if(returnMessage == null || "".equals(returnMessage)) {
                int result = s021100030Store.deleteMember(S021100030Vo.UpdateMemberTp
                        .builder()
                        .memberId(reqDto.getMemberId())
                        .loginId(reqDto.getLoginId()) /*2022.10.27 kjy*/
                        .build());
                if(result > 0) {
                    return response.success("회원정보를 정상적으로 삭제했습니다.");
                }
            }
            return response.success(returnMessage);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public ResponseEntity<?> updateMember(S021100030Dto.UpdateMemberTp reqDto) {
        int result = s021100030Store.updateMemberTp(
                S021100030Vo.UpdateMemberTp
                    .builder()
                        .memberId(reqDto.getMemberId())
                        .memberTp(reqDto.getMemberTp())
                        .loginId(reqDto.getLoginId()) /*2022.10.27 kjy*/
                    .build());

        if(result > 0) {
            return response.success("회원구분을 정상적으로 update했습니다.");
        }
        return response.fail("회원구분을 update하는데 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> insertUploadMember(int orgId, int loginId
                                              , List<S021100030Dto.UploadMemberDto> uploadMemberDtoList) {
        int count = 0;
        int totCount = 0;
        int result = 0;
        try {
            //회원정보 확인
            totCount = uploadMemberDtoList.size();
            logger.info("[S021100030D] 회원 일괄업로드 count =>" + uploadMemberDtoList.size());

            // insert : 넘겨받은 회원정보수 만큼 vo로 변환하여 looping
            ObjectMapper mapper = new ObjectMapper();

            for (S021100030Dto.UploadMemberDto uploadMemberDto : uploadMemberDtoList) {
                result = 0;
                S021100030Vo.UploadMemberVo uploadMemberVo = mapper.convertValue(
                        uploadMemberDto, S021100030Vo.UploadMemberVo.class);
                uploadMemberVo.setOrgId(orgId);
                uploadMemberVo.setLoginId(loginId);
                //vo convert toJson
                String jsonString = mapper.writeValueAsString(uploadMemberVo);
                logger.info("[S021100030D] 회원 row data=>" + jsonString);

                result = s021100030Store.insertUploadMember(uploadMemberVo);
                logger.info("[S021100030D] " + uploadMemberDto.getMemberName() + " 처리결과 =>" + result);
                count++;
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
//            throw e;
        }
        if (count > 0) {
            return response.success(count, "회원등록 upload(" + count + "/" + totCount + "(총) 건) 성공했습니다.", HttpStatus.OK);
        }
        return response.fail("회원등록 upload 에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
