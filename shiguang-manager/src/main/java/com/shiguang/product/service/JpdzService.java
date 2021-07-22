package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.JpdzDO;

import java.util.List;
import java.util.Map;

/**
 * 镜片定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
public interface JpdzService {

    JpdzDO get(Long id);

    List<JpdzDO> listDz(Map<String, Object> map);

    int countDz(Map<String, Object> map);

    int save(JpdzDO jpdz);

    int update(JpdzDO jpdz);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询镜片定做制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);
}
