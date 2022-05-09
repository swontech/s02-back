package com.swontech.s02.domain.logic.s022;

import com.swontech.s02.domain.dto.comm.ResponseDto;
import com.swontech.s02.domain.dto.s022.S022300080Dto;
import com.swontech.s02.domain.spec.s022.S022300080Spec;
import com.swontech.s02.domain.store.s022.S022300080Store;
import com.swontech.s02.domain.vo.s022.S022300080Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class S022300080Logic implements S022300080Spec {
    private final ResponseDto response;
    private final S022300080Store s022300080Store;
    public S022300080Logic(ResponseDto response, S022300080Store s022300080Store) {
        this.response = response;
        this.s022300080Store = s022300080Store;
    }

    @Override
    public ResponseEntity<?> retrieveAttendList(S022300080Dto.RetrieveAttendList reqDto) {
        if(reqDto.getEventId() == null) {
            return response.fail("행사ID(event-id)는 Null일 수 없습니다.", HttpStatus.BAD_REQUEST);
        }
        return response.success(s022300080Store.selectEnterList(
                S022300080Vo.SelectEnterListVo
                        .builder()
                            .eventId(reqDto.getEventId())
                            .enterFlag(reqDto.getEnterFlag())
                            .memberName(reqDto.getMemberName())
                            .hpNo(reqDto.getHpNo())
                        .build()
        ));
    }

    @Override
    public ResponseEntity<?> registerAttend(List<S022300080Dto.RegisterAttend> reqDto) {
        List<S022300080Vo.InsertEnterVo> list = new ArrayList<>();
        for(int i = 0; i < reqDto.size(); i++) {
            list.add(i, S022300080Vo.InsertEnterVo
                    .builder()
                            .memberId(reqDto.get(i).getMemberId())
                            .eventId(reqDto.get(i).getEventId())
                    .build()
            );
        }
        return response.success(s022300080Store.insertEnter(list) == 1, "참석 여부 등록이 성공적으로 완료되었습니다.", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteAttend(List<S022300080Dto.DeleteAttend> reqDto) {
        List<S022300080Vo.DeleteEnterVo> list = new ArrayList<>();
        for(int i = 0; i < reqDto.size(); i++) {
            list.add(i, S022300080Vo.DeleteEnterVo
                    .builder()
                            .eventId(reqDto.get(i).getEventId())
                            .memberId(reqDto.get(i).getMemberId())
                    .build());
        }

        return response.success(s022300080Store.deleteEnter(list));
    }
}
