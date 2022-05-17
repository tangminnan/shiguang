package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.KjjyDO;
import com.shiguang.jiancha.domain.KjyyDO;
import com.shiguang.jiancha.domain.ResultDO;

import java.util.List;
import java.util.Map;

/**
 * 框架近用表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-13 17:28:13
 */
public interface KjjyService {

    KjjyDO get(Long kjjyId);

    List<KjjyDO> list(Map<String, Object> map);
//    List<KjjyDO> chufangall(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(KjjyDO kjjy);

    int savekjjy(ResultDO result);
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);

    int remove(Long kjjyId);
    int upremove(KjjyDO kjjyDO);

    int updatekjjy(KjjyDO kjjyDO);

    int batchRemove(Long[] kjjyIds);

    KjjyDO chufangall(String ptometryNumber,String status);
}
