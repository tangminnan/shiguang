package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
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


    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);


    //删除修改状态
    int updateState(YxdzDO yxdz);

    //判断是否存在商品代码
    List<YxdzDO> haveNum(Map<String, Object> map);
}
