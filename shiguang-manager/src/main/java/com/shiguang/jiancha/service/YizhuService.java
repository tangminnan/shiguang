package com.shiguang.jiancha.service;

import com.shiguang.jiancha.domain.YizhuDO;

import java.util.List;
import java.util.Map;

/**
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-09 18:47:47
 */
public interface YizhuService {

    YizhuDO get(Long yizhuId);

    List<YizhuDO> findYizhu(Map<String, Object> map);

    int findYizhucount(Map<String, Object> map);

    int save(YizhuDO yizhu);

    int update(YizhuDO yizhu);

    int remove(Long yizhuId);

    int batchRemove(Long[] yizhuIds);


}
