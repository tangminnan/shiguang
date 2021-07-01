package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.HlyDO;

import java.util.List;
import java.util.Map;

/**
 * 隐形护理液表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:08:33
 */
public interface HlyService {

    HlyDO get(Long id);

    List<HlyDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(HlyDO hly);

    int update(HlyDO hly);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询护理液制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);
}
