package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.CustomResponse;
import com.swontech.s02.domain.dto.s022.S022300050Dto;
import com.swontech.s02.domain.spec.s022.S022300050Spec;
import com.swontech.s02.domain.store.s022.S022300050Store;
import com.swontech.s02.domain.vo.s022.S022300050Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
public class S022300050Logic implements S022300050Spec {
    private final S022300050Store s022300050Store;
    private final CustomResponse response;
    public S022300050Logic(S022300050Store s022300050Store, CustomResponse response) {
        this.s022300050Store = s022300050Store;
        this.response = response;
    }
    @Override
    public ResponseEntity<?> registerEvent(S022300050Dto.RegisterEvent reqDto) {
        int result = s022300050Store.insertEvent(S022300050Vo.InsertEventVo.builder()
                        .eventNm(reqDto.getEventNm())
                        .eventStartDate(reqDto.getEventStartDate())
                        .eventEndDate(reqDto.getEventEndDate())
                        .eventLoc(reqDto.getEventLoc())
                        .eventHostId(reqDto.getEventHostId())
                        .eventComment(reqDto.getEventComment())
                .build()
        );

        if(result < 1) {
            throw new RuntimeException("데이터를 저장하는 중 오류가 발생했습니다.");
        }
        return response.success("데이터를 성공적으로 저장했습니다.");
    }

    @Override
    public ResponseEntity<?> retrieveEvent(String eventId) {
        return response.success(s022300050Store.retrieveEvent(eventId));
    }

    @Override
    public ResponseEntity<?> patchEvent() {
        return null;
    }
}
