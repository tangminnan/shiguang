package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
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
 * @date 2021-07-23 13:35:38
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


    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);

    //删除修改状态
    int updateState(YxcpDO yxcp);
}
