package com.swontech.s02.domain.vo.s021;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

public class S021100090Vo {

    @Builder
    public static class ParamsVo {
        private int orgId;
        private int customerId;
        private String customerName;        /*화면의 상호명*/
        private String ceoName;				/*화면의 대표자명*/
        private String businessRegNo;		/*화면의 사업자번호 10자리*/
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbCustomer010Vo {
        private int customerId;
        private String createProgramId; //= "S021100090";
        private String updateProgramId; //= "S021100090";
        private int orgId;
        private String customerName;            /*화면의 상호명*/
        private String businessType;		    /*화면의 업태*/
        private String businessService;		    /*화면의 종목*/
        private String businessRegNo;		    /*화면의 사업자번호 10자리*/
        private String businessImgFileId;	    /*화면의 사업자사본 파일명*/
        private String businessImgFileName;	    /*첨부파일 사업자사본 */
        private String coZipCode;			    /*회사 우편번호*/
        private String coAddress;			    /*회사 주소*/
        private String coDetailAddress;		    /*회사 상세주소*/
        private String ceoName;				    /*화면의 대표자명*/
        private String ceoHpNo;				    /*화면의 대표자 Hp*/
        private String ceoEmail;			    /*화면의 대표자 Email*/
        private String ceoZipCode;			    /*화면의 대표자 우편번호*/
        private String ceoAddress;			    /*화면의 대표자 주소*/
        private String ceoDetailAddress;	    /*화면의 대표자 상세주소*/
        private String ceoIdCardImgFileId;	    /*화면의 대표자 신분증 파일ID*/
        private String ceoIdCardImgFileName;	/*화면의 대표자 신분증 파일명*/
        private int memberId; /*로그인 memberId*/
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TbCustomer020Vo {
        private int customerId;
        private int seq;
        private String createProgramId; // = "S021100090";
        private String lastObjectId;
        private String updateProgramId; // = "S021100090";
        private int orgId;
        private String employeeName;
        private String employeeHpNo;
        private String employeeEmail;
        private String deptName;
        private String employeeComment;
        private int memberId; /*로그인 memberId*/
    }

        /**거래처 삭제 */
    @Builder
    public static class DeleteCustomerVo {
        private int orgId;
        private int customerId;
        private int memberId;           /*로그인 memberId*/
    }

}
