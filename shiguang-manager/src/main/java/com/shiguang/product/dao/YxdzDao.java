package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
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

    //查询隐形定做制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);

    //删除修改状态
    int updateState(YxdzDO yxdz);

}
