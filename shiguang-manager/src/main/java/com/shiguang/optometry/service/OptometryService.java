package com.shiguang.optometry.service;

import com.shiguang.member.domain.MemberDO;
import com.shiguang.optometry.domain.OptometryDO;
import com.shiguang.optometry.domain.ProcessAskDO;

import java.util.List;
import java.util.Map;

public interface OptometryService {
    OptometryDO get(Long id);

    List<OptometryDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(OptometryDO optometry);

    int update(OptometryDO optometry);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<OptometryDO> optoList(Map<String, Object> map);

    //散瞳前
    List<OptometryDO> optoFrontList(String cardNumber);


    //散瞳后
    List<OptometryDO> optoAfterList(String cardNumber);

    List<ProcessAskDO> processlist(Map<String, Object> map);

    List<MemberDO> findOptoList(Map<String,Object> map);

    int findOptoCount(Map<String,Object> map);


    //开检查单的
    List<OptometryDO> moenyList(Map<String, Object> map);
    //开检查单数量
    int moenyListcount(Map<String, Object> map);

    //检查用户
    List<OptometryDO> userList(Map<String, Object> map);
    //检查用户数量
    int userListcount(Map<String, Object> map);
}
