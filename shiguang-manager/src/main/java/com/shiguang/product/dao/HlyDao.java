package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.HlyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 隐形护理液表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:08:33
 */
@Mapper
public interface HlyDao {

    HlyDO get(Long id);

    List<HlyDO> list(Map<String, Object> map);

    List<HlyDO> gethly(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(HlyDO hly);

    int update(HlyDO hly);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询镜片定做制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);

    //删除修改状态
    int updateState(HlyDO hly);
}
