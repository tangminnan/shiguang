package com.shiguang.jiekou.service;

import com.shiguang.jiekou.domain.MemberJKDO;

import java.util.List;
import java.util.Map;

public interface MemberJKService {
    MemberJKDO getCardNumber(String cardNumber);

    List<MemberJKDO> list(Map<String, Object> map);

    int save(MemberJKDO member);

    int update(MemberJKDO member);

}
