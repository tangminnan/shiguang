package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.ResultDO;
import com.shiguang.jiancha.domain.YaopinDO;

import java.util.List;
import java.util.Map;

/**
 * jc药品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-14 18:14:46
 */
public interface YaopinService {

    YaopinDO get(Long ypId);

    List<YaopinDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(YaopinDO yaopin);

    int saveYaopin(ResultDO result);

    int update(YaopinDO yaopin);
    int remove(Long ypId);
    int upremove(YaopinDO yaopinDO);

    int batchRemove(Long[] ypIds);
}
