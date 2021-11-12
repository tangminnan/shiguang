package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SgjjDO;

import java.util.List;
import java.util.Map;

/**
 * 框架双光/渐进表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 10:03:39
 */
public interface SgjjService {

    SgjjDO get(Long sgjjId);

    List<SgjjDO> list(Map<String, Object> map);
//    List<SgjjDO> chufangall(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(SgjjDO sgjj);

    int savesgjj(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long sgjjId);
    int upremove(SgjjDO sgjjDO);

    int updatesgjj(SgjjDO sgjjDO);

    int batchRemove(Long[] sgjjIds);

    SgjjDO chufangall(String ptometryNumber,String status);

}
