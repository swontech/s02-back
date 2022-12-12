package com.swontech.s02.domain.dto.s021;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

public class S021100090Dto {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ParamsDto {
        private int orgId;
        private int customerId;
        private String customerName;        /*화면의 상호명*/
        private String ceoName;				/*화면의 대표자명*/
        private String businessRegNo;		/*화면의 사업자번호 10자리*/
    }

    /** 거래처 등록 및 수정 항목 */
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterCustomerDto {
        private int customerId;
//        private String createProgramId;
        private String programId = "S021100090";
        private int orgId;
        private String customerName;        /*화면의 상호명*/
        private String businessType;		/*화면의 업태*/
        private String businessService;		/*화면의 종목*/
        private String businessRegNo;		/*화면의 사업자번호 10자리*/
        private String businessImgFileId;	/*화면의 사업자사본 파일명*/
        private String businessImgFileName;	/*첨부파일 사업자사본 */
        private String coZipCode;			/*회사 우편번호*/
        private String coAddress;			/*회사 주소*/
        private String coDetailAddress;		/*회사 상세주소*/
        private String ceoName;				/*화면의 대표자명*/
        private String ceoHpNo;				/*화면의 대표자 Hp*/
        private String ceoEmail;			/*화면의 대표자 Email*/
        private String ceoZipCode;			/*화면의 대표자 우편번호*/
        private String ceoAddress;			/*화면의 대표자 주소*/
        private String ceoDetailAddress;	/*화면의 대표자 상세주소*/
        private String comImgBase64String;
        private String ceoImgBase64String;
        private String ceoIdCardImgFileId;	/*화면의 대표자 신분증 파일ID*/
        private String ceoIdCardImgFileName;	/*화면의 대표자 신분증 파일명*/
        private int memberId; /*로그인 memberId*/
    }

    /** 거래처 직원등록 항목 */
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegisterCustomerMemberDto {
        private int seq;
        private String createProgramId;
        private String employeeName;    /*화면 직원명*/
        private String employeeHpNo;    /*화면 직원 HP_NO*/
        private String employeeEmail;   /*화면 Email*/
        private String deptName;        /*화면 부서명*/
        private String employeeComment; /*화면 비고*/
        private int memberId;           /*로그인 memberId*/
    }

    /** 거래처 조회항목 */
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CustomerList {
        private int customerId;
        private String customerName;
        private String businessRegNo;		/*화면의 사업자번호 10자리*/
        private String ceoName;				/*화면의 대표자명*/
        private String ceoHpNo;				/*화면의 대표자 Hp*/
        private String ceoEmail;			/*화면의 대표자 Email*/
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CustomerDetailInfo {
        private String customerName;        /*화면의 상호명*/
        private String businessType;		/*화면의 업태*/
        private String businessService;		/*화면의 종목*/
        private String businessRegNo;		/*화면의 사업자번호 10자리*/
        private String businessImgFileId;	/*화면의 사업자사본 파일명*/
        private String businessImgFileName;	/*첨부파일 사업자사본 */
        private String coZipCode;			/*회사 우편번호*/
        private String coAddress;			/*회사 주소*/
        private String coDetailAddress;		/*회사 상세주소*/
        private String ceoName;				/*화면의 대표자명*/
        private String ceoHpNo;				/*화면의 대표자 Hp*/
        private String ceoEmail;			/*화면의 대표자 Email*/
        private String ceoZipCode;			/*화면의 대표자 우편번호*/
        private String ceoAddress;			/*화면의 대표자 주소*/
        private String ceoDetailAddress;	/*화면의 대표자 상세주소*/
        private String ceoIdCardImgFileId;	/*화면의 대표자 신분증 파일ID*/
        private String ceoIdCardImgFileName;	/*화면의 대표자 신분증 파일명*/
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    public static class CustomerMemberList {
        private int seq;                /*거래처직원순번*/
        private String employeeName;    /*화면 직원명*/
        private String employeeHpNo;    /*화면 직원 HP_NO*/
        private String employeeEmail;   /*화면 Email*/
        private String deptName;        /*화면 부서명*/
        private String employeeComment; /*화면 비고*/
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DeleteCustomerDto {
        private int orgId;
        private int customerId;
        private int memberId;       /*로그인 memberId*/
    }

}
