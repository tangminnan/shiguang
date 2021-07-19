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

    int update(VstDO vst);

    int remove(Long vstId);

    int batchRemove(Long[] vstIds);
}
