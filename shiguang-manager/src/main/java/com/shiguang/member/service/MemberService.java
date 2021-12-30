package com.shiguang.member.service;

import com.shiguang.common.utils.R;
import com.shiguang.member.domain.MemberDO;
import com.shiguang.settlement.domain.JieKuanMoneyDO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface MemberService {
    MemberDO get(Long id);

    MemberDO getCardNumber(String cardNumber);

    List<MemberDO> list(Map<String, Object> map);

    List<JieKuanMoneyDO> payList(Map<String,Object> map);

    List<JieKuanMoneyDO> payCountList(Map<String,Object> map);

    int count(Map<String, Object> map);

    List<MemberDO> heightlist(Map<String,Object> map);

    int heightcount(Map<String,Object> map);

    int payCount(Map<String, Object> map);

    int save(MemberDO member);

    int update(MemberDO member);

    int remove(Long id);

    int batchRemove(Long[] ids,Long status);
    int updateStatus(MemberDO memberDO);

    R importMember(String departNumber, String checkType, MultipartFile file);

    //视光检查用户List
    List<MemberDO> yanguangList(Map<String, Object> map);
    int yanguangCount(Map<String, Object> map);
}
