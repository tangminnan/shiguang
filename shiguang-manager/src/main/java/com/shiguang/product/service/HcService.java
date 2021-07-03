package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.HcDO;

import java.util.List;
import java.util.Map;

/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 17:14:05
 */
public interface HcService {

    HcDO get(Long id);

    List<HcDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(HcDO hc);

    int update(HcDO hc);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询耗材制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);
}
