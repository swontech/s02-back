package com.swontech.s02.domain.logic.s021;

import com.swontech.s02.domain.dto.S021.S021300010Dto;
import com.swontech.s02.domain.spec.s021.S021300010Spec;
import com.swontech.s02.domain.store.S021300010Store;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class S021300010Logic implements S021300010Spec {
    private final S021300010Store s021300010Store;
    public S021300010Logic(S021300010Store s021300010Store) {
        this.s021300010Store = s021300010Store;
    }

    /**
     * 코드 List를 검색한다.
     * @param 'S021300010Dto$RetrieveWord body(검색어)
     * @return List<S021300010Dto.CodeList>
     */
    @Override
    public List<S021300010Dto.CodeList> retrieveCodeList(S021300010Dto.RetrieveWord body) {
        List<Map<String, Object>> res = s021300010Store.retrieveCodeList(body);
        res.forEach(o -> {
            log.info(o.toString());
        });

        return null;
    }

    /**
     * 코드의 DATA_END상태를 수정(삭제/복원)시킨다.
     * @param 'S021300010Dto$PatchCodeStatus body
     * @param dataEndFlag
     */
    @Override
    public void patchCodeStatus(S021300010Dto.PatchCodeStatus body, String dataEndFlag) {

        try {

            /** --------------------------------------------------------------------------
             * dataaEndFlag별로 분기한다.
             * dataEndFlag가 Y면 삭제, 아니면 복원
             * mapper에서 분기할 수 있으나 mapper.xml파일이 복잡해지고 향후 Logic의 수정 가능성이 있음. */
            if("Y".equals(dataEndFlag)) {
                s021300010Store.deleteCode(body);
            } else {
                s021300010Store.restoreCode(body);
            }


        } catch (Exception e) {

        } finally {

        }
    }
}
