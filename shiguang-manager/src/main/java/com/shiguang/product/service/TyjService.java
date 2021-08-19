package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.TyjDO;

import java.util.List;
import java.util.Map;

/**
 * 太阳镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:45:54
 */
public interface TyjService {

    TyjDO get(Long id);

    List<TyjDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TyjDO tyj);

    int update(TyjDO tyj);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //菜单联动显示
    List<BrandDO> choice(Integer mfrsid);

    //删除修改状态
    int updateState(TyjDO tyj);

    //判断是否存在商品代码
    List<TyjDO> haveNum(Map<String, Object> map);
}
