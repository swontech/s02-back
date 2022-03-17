package com.swontech.s02.domain.store;

import com.swontech.s02.domain.dto.S021.S021300010Dto;

import java.util.List;
import java.util.Map;

public interface S021300010Store {
    /**
     * 코드 리스트 검색 use case
     * @param 'S021300010Dto.RetrieveWord'
     * @return 'List<S021300010Dto.CodeList>'
     */
    List<Map<String, Object>> retrieveCodeList(S021300010Dto.RetrieveWord param);

    /**
     * 선택코드 삭제 use case
     * @param 'S021300010Dto.PatchCodeStatus param'
     * @return 'List<S021300010Dto.PatchCodeStatus>'
     */
    void deleteCode(S021300010Dto.PatchCodeStatus param);

    /**
     * 삭제된 코드 복원  use case
     * @param 'S021300010Dto.PatchCodeStatus param'
     * @return 'List<S021300010Dto.PatchCodeStatus>'
     */
    void restoreCode(S021300010Dto.PatchCodeStatus param);
}
