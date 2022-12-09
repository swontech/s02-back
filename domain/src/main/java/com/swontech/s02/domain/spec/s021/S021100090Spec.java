package com.swontech.s02.domain.spec.s021;

import com.swontech.s02.domain.dto.s021.S021100090Dto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface S021100090Spec {
    /*거래처 리스트*/
    ResponseEntity<?> retrieveCustomerList(S021100090Dto.ParamsDto paramsDto);
    ResponseEntity<?> retrieveCustomerDetail(S021100090Dto.ParamsDto paramsDto);

    ResponseEntity<?> retrieveCustomerMemberList(int orgId, int customerId);

    /** 거래처 등록 */
    ResponseEntity<?> registerCustomer(S021100090Dto.RegisterCustomerDto reqDto);

    /** 거래처 회원 등록 */
    ResponseEntity<?> registerCustomerMember(int eventId, List<S021100090Dto.RegisterCustomerMemberDto> listMemberDto );

    /** 거래처 수정 */
    ResponseEntity<?> patchCustomer(S021100090Dto.RegisterCustomerDto reqDto);

    /** 거래처 저장 : 화면에서 저장버튼 기능 */
    ResponseEntity<?> saveCustomer(int oegId, int customerId,
                                   S021100090Dto.RegisterCustomerDto registerCustomerDto,
                                   List<S021100090Dto.RegisterCustomerMemberDto> listCustomerMemberDto);
    /* 거래처 삭제 */
    ResponseEntity<?> deleteCustomer(int orgId, int memberId, List<Integer> customerIdList);

}
