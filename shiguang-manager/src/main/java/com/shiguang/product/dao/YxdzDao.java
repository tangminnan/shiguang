package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.YxdzDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 隐形定做表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 18:02:16
 */
@Mapper
public interface YxdzDao {

    YxdzDO get(Long id);

    List<YxdzDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(YxdzDO yxdz);

    int update(YxdzDO yxdz);

    int remove(Long id);

    int batchRemove(Long[] ids);




    //删除修改状态
    int updateState(YxdzDO yxdz);
    //判断是否存在商品代码
    List<YxdzDO> haveNum(Map<String, Object> map);

    YxdzDO getYxdzInfomation(String goodNum);
}
