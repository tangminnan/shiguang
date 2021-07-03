package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.ShiguangDO;

import java.util.List;
import java.util.Map;

/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */
public interface ShiguangService {

    ShiguangDO get(Long id);

    List<ShiguangDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ShiguangDO shiguang);

    int update(ShiguangDO shiguang);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询视光制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);
}
