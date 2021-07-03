package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.YxdzDO;

import java.util.List;
import java.util.Map;

/**
 * 隐形定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:02:16
 */
public interface YxdzService {

    YxdzDO get(Long id);

    List<YxdzDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(YxdzDO yxdz);

    int update(YxdzDO yxdz);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询隐形定做制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);

    List<YxdzDO> listYxDz(Map<String, Object> map);

    int countYxDz(Map<String, Object> map);
}
