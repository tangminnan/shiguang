package com.shiguang.jiekou.dao;

import com.shiguang.jiekou.domain.MemberJKDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("MemberJKDao")
public interface MemberJKDao {

    MemberJKDO getCardNumber(String cardNumber);

    List<MemberJKDO> list(Map<String,Object> map);

    int save(MemberJKDO member);

    int update(MemberJKDO member);

}
