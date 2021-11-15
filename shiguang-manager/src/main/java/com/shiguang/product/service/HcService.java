package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HcDO;
import com.shiguang.product.domain.ProducaDO;

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

    //菜单联动显示
    List<BrandDO> choice(String mfrsid);

    //删除修改状态
    int updateState(HcDO hc);
    //判断是否存在商品代码
    List<HcDO> haveNum(Map<String, Object> map);

    HcDO getHcInfomation(String goodNum);
}
