package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.s021.S021100090Dto;
import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.spec.comm.S3BucketSpec;
import com.swontech.s02.domain.spec.s021.S021100090Spec;
import com.swontech.s02.domain.store.s021.S021100090Store;
import com.swontech.s02.domain.vo.s021.S021100090Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.util.List;

@Slf4j
public class S021100090Logic implements S021100090Spec {
    private final CustomResponse response;
    private final S3BucketSpec s3BucketSpec;
    private final S021100090Store s021100090Store;
    private final String _PROGRAM_ID = "S021100090";

    public S021100090Logic(S021100090Store s021100090Store, CustomResponse response, S3BucketSpec s3BucketSpec) {
        this.s021100090Store = s021100090Store;
        this.response = response;
        this.s3BucketSpec = s3BucketSpec;
    }

    @Override
    public ResponseEntity<?> retrieveCustomerList(S021100090Dto.ParamsDto paramsDto) {

        return response.success(s021100090Store.selectCustomerList(S021100090Vo.ParamsVo.builder()
                            .orgId(paramsDto.getOrgId())
                            .customerName(paramsDto.getCustomerName())
                            .businessRegNo(paramsDto.getBusinessRegNo())
                            .ceoName(paramsDto.getCeoName()).build()
                        ));
    }
    @Override
    public ResponseEntity<?> retrieveCustomerDetail(int orgId, int customerId) {
        log.info("거래처 상세조회 customerId :"+ customerId);
        return response.success(s021100090Store.selectCustomerDetail(S021100090Vo.ParamsVo.builder()
                            .orgId(orgId)
                            .customerId(customerId).build()
            ));
    }

    @Override
    public ResponseEntity<?> retrieveCustomerMemberList(int customerId) {
        return response.success(s021100090Store.selectCustomerMemberList(S021100090Vo.ParamsVo.builder()
                .customerId(customerId).build()
        ));
    }

    @Override
    public ResponseEntity<?> registerCustomer(S021100090Dto.RegisterCustomerDto regDto) {
        int result = 0;
        try {
            result = this.insertCustomer(regDto);

            return response.success(result, "거래처 정상 등록처리되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return response.fail(result, "거래처 등록 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<?> registerCustomerMember(int eventId, List<S021100090Dto.RegisterCustomerMemberDto> listemberDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> patchCustomer(S021100090Dto.RegisterCustomerDto reqDto) {
        return null;
    }

    /*거래처 저장 : 등록,수정(직원 포함) */
    @Override
    public ResponseEntity<?> saveCustomer(int orgId, int customerId
                    , S021100090Dto.RegisterCustomerDto registerCustomerDto
                    , List<S021100090Dto.RegisterCustomerMemberDto> listCustomerMemberDto) {
        try
        {
            int result = 0;
            boolean isSuccess = false;
            registerCustomerDto.setOrgId(orgId);
            /**
             * customerId 가 있으면 수정, 0 이면 신규등록
             */
            if(customerId > 0) {
                registerCustomerDto.setCustomerId(customerId);
                result = this.updateCustomer(registerCustomerDto);
                log.info("[S021100090] 거래처 수정 결과 : "+ result);

                //기존 거래처의 직원 삭제
                if(result > 0) {
                    result = s021100090Store.deleteCustomerMember(S021100090Vo.DeleteCustomerVo.builder()
                                        .orgId(orgId).customerId(customerId).build()
                                );
                    log.info("[S021100090] 거래처 회원 삭제 결과 : "+ result);
                    isSuccess = true;
                }
            } else {
                //신규 등록
                result = this.insertCustomer(registerCustomerDto);
                log.info("[S021100090] 거래처 신규등록 customerId : " + result);
                customerId = result; //신규등록시 발번된 sequence
                isSuccess = true;
            }

            //거래처 직원 등록 처리
            if(isSuccess) {
                isSuccess = false;

                // 회원정보 insert : 넘겨받은 회원정보수 만큼 vo로 변환하여 looping
                for (S021100090Dto.RegisterCustomerMemberDto memberDto : listCustomerMemberDto) {
                    result = 0;
                    S021100090Vo.TbCustomer020Vo memberVo = S021100090Vo.TbCustomer020Vo.builder()
                            .updateProgramId(this._PROGRAM_ID)
                            .seq(memberDto.getSeq())
                            .customerId(customerId)
                            .employeeName(memberDto.getEmployeeName())
                            .employeeHpNo(memberDto.getEmployeeHpNo())
                            .employeeEmail(memberDto.getEmployeeEmail())
                            .deptName(memberDto.getDeptName())
                            .employeeComment(memberDto.getEmployeeComment())
                            .memberId(memberDto.getMemberId())
                            .build();
                    log.info("[S021100090] 거래처 회원등록 대상 MemberId: " + memberVo.getMemberId() );

                    result = s021100090Store.insertCustomerMember(memberVo);

                    log.info("[S021100090] 거래처 회원등록 처리결과: " + result);
                }
                if(result > 0) isSuccess = true;
            }
            //최종 직원등록까지 정상이면 success
            if(isSuccess) {
                return response.success(customerId, "거래처 정보 저장에 성공했습니다.", HttpStatus.OK);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
        return response.fail("거래처 저장에 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<?> deleteCustomer(int orgId, int memberId, List<Integer> customerIdList) {
        int curCustomerId = 0;
        try {
            for (int customerId : customerIdList) {
                curCustomerId = customerId;
                s021100090Store.deleteCustomer( S021100090Vo.DeleteCustomerVo.builder()
                                .orgId(orgId)
                                .customerId(customerId)
                                .memberId(memberId)
                        .build());
            }
            log.info("[S021100090] 거래처 삭제 처리결과: " + curCustomerId);
            
        }  catch (RuntimeException e) {
            log.error(e.getMessage());
            return response.fail("거래처 " + curCustomerId + "를 삭제처리 중 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response.success("","거래처 삭제처리되었습니다", HttpStatus.OK);
    }


    private int insertCustomer(S021100090Dto.RegisterCustomerDto regDto) {
        int newCustomerId = 0;
        try {
            //사업자 사본 이미지 첨부
            String comImgFileId = this.imgUpload(null, regDto.getComImgBase64String(), "customer");
            //대표자 사진 첨부
            String ceoImgFileId = this.imgUpload(null, regDto.getCeoImgBase64String(), "ceo");
            log.info("[S021100090] 거래처 사업자 사본 이미지첨부 결과 : " + comImgFileId);
            log.info("[S021100090] 거래처 대표자 사진 첨부 결과 : " + ceoImgFileId);

            S021100090Vo.TbCustomer010Vo registerVo = this.setCustomerVo(regDto);
            registerVo.setBusinessImgFileId(comImgFileId);
            registerVo.setCeoIdCardImgFileId(ceoImgFileId);

            int rsCnt = s021100090Store.insertCustomer(registerVo);
            if(rsCnt >0) {
                newCustomerId = registerVo.getCustomerId();
                log.info("[S021100090] 거래처 신규등록 처리결과 customerId : " + newCustomerId);
;            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return newCustomerId;
    }

    private int updateCustomer(S021100090Dto.RegisterCustomerDto reqDto) {
        int result = 0;
        try {
            String curComImgFileId = reqDto.getBusinessImgFileId();
            String curCeoImgFileId = reqDto.getCeoIdCardImgFileId();

            log.info("[S021100090] 거래처 기존 사업자 사본 : " + curComImgFileId);
            log.info("[S021100090] 거래처 기존 대표자 사진 : " + curCeoImgFileId);

            S021100090Vo.TbCustomer010Vo registerVo = this.setCustomerVo(reqDto);
            registerVo.setCustomerId(reqDto.getCustomerId());

            if (StringUtils.hasLength(reqDto.getComImgBase64String())) {
                //사업자 사본 이미지
                String comImgFileId = this.imgUpload(curComImgFileId, reqDto.getComImgBase64String(), "customer");
                registerVo.setBusinessImgFileId(comImgFileId);
                log.info("[S021100090] 거래처 사업자 사본 첨부화일 수정 : " + comImgFileId);
            }
            if (StringUtils.hasLength(reqDto.getComImgBase64String())) {
                //대표자 사진 첨부
                String ceoImgFileId = this.imgUpload(curCeoImgFileId, reqDto.getCeoImgBase64String(), "ceo");
                registerVo.setCeoIdCardImgFileId(ceoImgFileId);
                log.info("[S021100090] 거래처 대표자 첨부화일 수정 : " + ceoImgFileId);
            }

            result = s021100090Store.updateCustomer(registerVo);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    private S021100090Vo.TbCustomer010Vo setCustomerVo(S021100090Dto.RegisterCustomerDto regDto){
        return S021100090Vo.TbCustomer010Vo.builder()
                .createProgramId(this._PROGRAM_ID)
                .updateProgramId(this._PROGRAM_ID)
                .orgId(regDto.getOrgId())
                .memberId(regDto.getMemberId())
                .customerName(regDto.getCustomerName())        /*화면의 상호명*/
                .businessType(regDto.getBusinessType())		    /*화면의 업태*/
                .businessService(regDto.getBusinessService())	/*화면의 종목*/
                .businessRegNo(regDto.getBusinessRegNo())		/*화면의 사업자번호 10자리*/
                .businessImgFileName(regDto.getBusinessImgFileName())		/*화면의 사업자사본 파일명 */
                .coZipCode(regDto.getCoZipCode())				/*회사 우편번호*/
                .coAddress(regDto.getCoAddress())				/*회사 주소*/
                .coDetailAddress(regDto.getCoDetailAddress())	/*회사 상세주소*/
                .ceoName(regDto.getCeoName())				/*화면의 대표자명*/
                .ceoHpNo(regDto.getCeoHpNo())				/*화면의 대표자 Hp*/
                .ceoEmail(regDto.getCeoEmail())			    /*화면의 대표자 Email*/
                .ceoZipCode(regDto.getCeoZipCode())			/*화면의 대표자 우편번호*/
                .ceoAddress(regDto.getCeoAddress())			/*화면의 대표자 주소*/
                .ceoDetailAddress(regDto.getCeoDetailAddress())	/*화면의 대표자 상세주소*/
                .ceoIdCardImgFileName(regDto.getCeoIdCardImgFileName())	/*화면의 대표자 신분증 파일명*/
                .build();
    }

    private String imgUpload(String imgFileId, String base64String, String flag) {

        String rsImgFileId = null;
        /* 첨부화일 처리 조건
         * : base64String 항목값 유무에 따라 기존화일 삭제 체크
         */
        if (StringUtils.hasLength(base64String)) {
            //imgFileId != 널이면 수정이므로 기존 파일 삭제 후 첨부
            if (StringUtils.hasLength(imgFileId)) {
                s3BucketSpec.delete(imgFileId, flag);    //기존 파일 삭제
            }
            rsImgFileId = s3BucketSpec.upload(base64String, flag);  //신규 화일 첨부
        }
        return rsImgFileId;
    }

}
