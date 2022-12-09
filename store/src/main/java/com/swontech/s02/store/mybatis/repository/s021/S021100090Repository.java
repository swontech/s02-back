package com.swontech.s02.store.mybatis.repository.s021;

import com.swontech.s02.domain.dto.s021.S021100090Dto;
import com.swontech.s02.domain.store.s021.S021100090Store;
import com.swontech.s02.domain.vo.s021.S021100090Vo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class S021100090Repository implements S021100090Store {
    private final SqlSessionTemplate sqlSessionTemplate;

    public S021100090Repository(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<S021100090Dto.CustomerList> selectCustomerList(S021100090Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.selectList("S021100090.selectCustomerList", paramsVo);
    }

    @Override
    public S021100090Dto.CustomerDetailInfo selectCustomerDetail(S021100090Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.selectOne("S021100090.selectCustomerDetail", paramsVo);
    }

    @Override
    public List<S021100090Dto.CustomerMemberList> selectCustomerMemberList(S021100090Vo.ParamsVo paramsVo) {
        return sqlSessionTemplate.selectList("S021100090.selectCustomerMemberList", paramsVo);
    }

    @Override
    public int insertCustomer(S021100090Vo.TbCustomer010Vo customer010Vo) {
        return sqlSessionTemplate.insert("S021100090.insertCustomer", customer010Vo);
    }

    @Override
    public int updateCustomer(S021100090Vo.TbCustomer010Vo customer010Vo) {
        return sqlSessionTemplate.update("S021100090.updateCustomer", customer010Vo);
    }

    @Override
    public int deleteCustomer(S021100090Vo.DeleteCustomerVo deleteCustomerVo) {
        return sqlSessionTemplate.delete("S021100090.deleteCustomer", deleteCustomerVo);
    }

    @Override
    public int insertCustomerMember(S021100090Vo.TbCustomer020Vo customer020Vo) {
        return sqlSessionTemplate.insert("S021100090.insertCustomerMember", customer020Vo);
    }

    @Override
    public int deleteCustomerMember(S021100090Vo.DeleteCustomerVo deleteCustomerVo) {
        return sqlSessionTemplate.delete("S021100090.deleteCustomerMember", deleteCustomerVo);
    }

}
