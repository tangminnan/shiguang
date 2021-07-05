package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.TyjDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 太阳镜表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-07-01 11:45:54
 */
@Mapper
public interface TyjDao {

    TyjDO get(Long id);

    List<TyjDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(TyjDO tyj);

    int update(TyjDO tyj);

    int remove(Long id);

    int batchRemove(Long[] ids);

    //查询太阳镜制造商
    List<MgDO> mglist(Map<String, Object> map);

    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);
}