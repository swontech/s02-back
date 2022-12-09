package com.swontech.s02.domain.store.s021;

import com.swontech.s02.domain.dto.s021.S021100090Dto;
import com.swontech.s02.domain.vo.s021.S021100090Vo;

import java.util.List;

public interface S021100090Store {
    /*거래처 리스트*/
    List<S021100090Dto.CustomerList> selectCustomerList(S021100090Vo.ParamsVo paramsVo);
    /*거래처 상세조회*/
    S021100090Dto.CustomerDetailInfo selectCustomerDetail(S021100090Vo.ParamsVo paramsVo);
    /*거래처  직원 리스트 */
    List<S021100090Dto.CustomerMemberList> selectCustomerMemberList(S021100090Vo.ParamsVo paramsVo);

    /*거래처 등록*/
    int insertCustomer(S021100090Vo.TbCustomer010Vo customer010Vo);

    /*거래처 수정*/
    int updateCustomer(S021100090Vo.TbCustomer010Vo customer010Vo);

    /*거래처 삭제*/
    int deleteCustomer(S021100090Vo.DeleteCustomerVo deleteCustomerVo);

    /*거래처 직원 등록*/
    int insertCustomerMember(S021100090Vo.TbCustomer020Vo customer020Vo);

    /*거래처 직원 삭제*/
    int deleteCustomerMember(S021100090Vo.DeleteCustomerVo deleteCustomerVo);

}
