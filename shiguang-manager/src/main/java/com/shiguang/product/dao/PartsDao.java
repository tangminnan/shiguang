package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
//import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.HlyDO;
import com.shiguang.product.domain.PartsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 配件表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
@Mapper
public interface PartsDao {

    PartsDO get(Long id);

    List<PartsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(PartsDO parts);

    //修改停用启用
    int update(PartsDO parts);

    int remove(Long id);

    int batchRemove(Long[] ids);

//    //查询配件制造商
//    List<MgDO> mglist(Map<String, Object> map);


    //删除修改状态
    int updateState(PartsDO parts);
    //判断是否存在商品代码
    List<PartsDO> haveNum(Map<String, Object> map);

    PartsDO getPartInfomation(String goodNum);
}
