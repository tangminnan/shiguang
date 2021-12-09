package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.ShiguangDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 视光表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 15:52:32
 */
@Mapper
public interface ShiguangDao {

    ShiguangDO get(Long id);

    List<ShiguangDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    //选择视觉训练-视光
    List<ShiguangDO> getshiguang(Map<String, Object> map);
    int getshiguangcount(Map<String, Object> map);
    int save(ShiguangDO shiguang);

    int update(ShiguangDO shiguang);

    int remove(Long id);

    int batchRemove(Long[] ids);


    //删除修改状态
    int updateState(ShiguangDO shiguang);

    //判断是否存在商品代码
    List<ShiguangDO> haveNum(Map<String, Object> map);

    ShiguangDO getShiguangInfomation(String goodNum);
}
