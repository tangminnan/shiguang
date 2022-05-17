package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.KjyyDO;
import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.TryresultsDO;

import java.util.List;
import java.util.Map;

/**
 * 框架远用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 17:28:13
 */
public interface KjyyService {

    KjyyDO get(Long kjyyId);

    List<KjyyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(KjyyDO kjyy);

    int savekjyy(ResultDO result);
    List<ResultDO> haveYanguangNum(Map<String, Object> map);

    int update(ResultDO result);
    int remove(Long kjyyId);
    int upremove(KjyyDO kjyyDO);

    int updatekjyy(KjyyDO kjyyDO);

    int batchRemove(Long[] kjyyIds);

    KjyyDO chufangall(String ptometryNumber,String status);
//List<KjyyDO> chufangall(Map<String, Object> map);
}
