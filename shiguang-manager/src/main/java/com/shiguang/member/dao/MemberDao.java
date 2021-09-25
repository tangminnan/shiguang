package com.shiguang.member.dao;

import com.shiguang.member.domain.MemberDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository("MemberDao")
public interface MemberDao {
    MemberDO get(Long id);

    MemberDO getCardNumber(String cardNumber);

    List<MemberDO> list(Map<String,Object> map);

    List<MemberDO> payList(Map<String,Object> map);

    int count(Map<String,Object> map);

    int payCount(Map<String,Object> map);

    int save(MemberDO member);

    int update(MemberDO member);

    int remove(Long id);

    int batchRemove(@Param("id") Long[] ids, @Param("status") Long status);

    int updateStatus(MemberDO memberDO);


    //视光检查用户List
    List<MemberDO> yanguangList(Map<String, Object> map);
    int yanguangCount(Map<String, Object> map);
}
