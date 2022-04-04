package com.swontech.s02.domain.dto.s021;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * S021300010 코드관리 화면 Dto
 */
public class S021300010Dto {
    /**
     * 코드 리스트 검색 Request DTO
     */
    @Getter
    @AllArgsConstructor
    @Builder
    public static class RetrieveWord {
        @NotBlank
        @ApiModelProperty(value = "단체ID(ORG_ID)", example = "1", required = true)
        private String orgId;

        @ApiModelProperty(value = "코드ID(CD_TP)", example = "A")
        private String cdTp;

        @ApiModelProperty(value = "코드명(CD_TP_MEANING)", example = "시스템Admin")
        private String cdTpMeaning;
    }

    /**
     * 코드 List Response DTO
     */
    @Getter
    @AllArgsConstructor
    @Builder
    public static class CodeList {
        @ApiModelProperty(value = "코드ID(CD_TP)", example = "A")
        private String cdTp;
        @ApiModelProperty(value = "코드명(CD_TP_MEANING)", example = "시스템Admin")
        private String cdTpMeaning;
        @ApiModelProperty(value = "CD_V", example = "")
        private String cdV;
        @ApiModelProperty(value = "CD_V_MEANING", example = "")
        private String cdVMeaning;
        @ApiModelProperty(value = "CATEGORY", example = "")
        private String category;
        @ApiModelProperty(value = "CATEGORY_NM", example = "")
        private String categoryNm;
        @ApiModelProperty(value = "DATA_END_STATUS", example = "")
        private String dataEndStatus;
    }

    /**
     * 코드 상태 변경 Request DTO
     */
    @Getter
    @AllArgsConstructor
    @Builder
    public static class PatchCodeStatus {
        @ApiModelProperty(value = "단체ID(ORG_ID)", example = "1")
        private String orgId;
        @ApiModelProperty(value = "코드명(CD_TP_MEANING)", example = "시스템Admin")
        private String cdTp;
    }
}
