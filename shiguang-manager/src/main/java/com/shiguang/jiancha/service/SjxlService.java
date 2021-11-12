package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.SjxlDO;

import java.util.List;
import java.util.Map;

/**
 * 视觉训练表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 14:02:19
 */
public interface SjxlService {

    SjxlDO get(Long sjxlId);

    List<SjxlDO> list(Map<String, Object> map);


    int count(Map<String, Object> map);

    int save(SjxlDO sjxl);

    int saveSjxl(ResultDO result);
    //    是否有保存这个验光号数据
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long sjxlId);
    int upremove(SjxlDO sjxlDO);

    int batchRemove(Long[] sjxlIds);

    SjxlDO chufangall(String ptometryNumber,String status);
}
