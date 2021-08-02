package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.ProducaDO;

import java.util.List;
import java.util.Map;

/**
 * 镜架新增表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
public interface ProducaService {
    ProducaDO get(Long id);

    List<MgDO> mglist(Map<String, Object> map);

    //修改时显示制造商和商品品种名称
    List<ProducaDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(ProducaDO produca);

    //修改停用启用
    int update(ProducaDO produca);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //菜单联动显示
    List<BrandDO> choice(Map<String, Object> map);

    //删除修改状态
    int updateState(ProducaDO produca);

}
