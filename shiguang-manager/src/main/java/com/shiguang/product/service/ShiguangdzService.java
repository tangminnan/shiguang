package com.shiguang.product.service;

import com.shiguang.product.domain.ShiguangDO;
import com.shiguang.product.domain.ShiguangdzDO;

import java.util.List;
import java.util.Map;

/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */
public interface ShiguangdzService {

    ShiguangdzDO get(Long id);

    List<ShiguangdzDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    //选择视觉训练-视光
    List<ShiguangdzDO> getshiguang(Map<String, Object> map);
    int getshiguangcount(Map<String, Object> map);

    int save(ShiguangdzDO shiguang);

    int update(ShiguangdzDO shiguang);

    int remove(Long id);

    int batchRemove(Long[] ids);



    //删除修改状态
    int updateState(ShiguangdzDO shiguang);

    //判断是否存在商品代码
    List<ShiguangdzDO> haveNum(Map<String, Object> map);

    ShiguangdzDO getShiguangInfomation(String goodNum);
}
