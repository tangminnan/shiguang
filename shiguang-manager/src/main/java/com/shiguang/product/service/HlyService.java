package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
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
    //选择护理液
    List<HlyDO> gethly(Map<String, Object> map);
    int gethlycount(Map<String, Object> map);

    int save(HlyDO hly);

    int update(HlyDO hly);

    int remove(Long id);

    int batchRemove(Long[] ids);



    //删除修改状态
    int updateState(HlyDO hly);

    //判断是否存在商品代码
    List<HlyDO> haveNum(Map<String, Object> map);

    HlyDO getHlyInfomation(String goodNum);
}
