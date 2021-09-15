package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.TryresultsDO;
import com.shiguang.member.domain.MemberDO;

import java.util.List;
import java.util.Map;

/**
 * 试戴镜结果表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 09:26:46
 */
public interface TryresultsService {

    TryresultsDO get(Long id);

    List<TryresultsDO> list(Map<String, Object> map);

    //根据人查相对应的验光号医生时间等信息
    List<TryresultsDO> listUser(String cardNumber);

    int count(Map<String, Object> map);

    int save(TryresultsDO tryresults);

    int update(TryresultsDO tryresults);

    int remove(Long id);

    int batchRemove(Long[] ids);
    //查询医生
    List<TryresultsDO> listDoctor(Map<String, Object> map);
    List<TryresultsDO> listYanguang(Map<String, Object> map);

    TryresultsDO getTryresult(Map<String, Object> map);
}
