package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.YxcpDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 隐形成品表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 16:07:55
 */
@Mapper
public interface YxcpDao {

    YxcpDO get(Long id);

    List<YxcpDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(YxcpDO yxcp);

    int update(YxcpDO yxcp);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询隐形成品制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);
}
