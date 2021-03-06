package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.VstDO;

import java.util.List;
import java.util.Map;

/**
 * 角膜接触镜VST
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 16:38:36
 */
public interface VstService {

    VstDO get(Long vstId);

    List<VstDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(VstDO vst);

    int saveVst(ResultDO result);
    List<ResultDO> haveYanguangNum(Map<String, Object> map);
    int update(ResultDO result);
    int remove(Long vstId);
    int upremove(VstDO vstDO);
    int updatevst(VstDO vstDO);
    int batchRemove(Long[] vstIds);
    VstDO chufangall(String ptometryNumber,String status);

}
