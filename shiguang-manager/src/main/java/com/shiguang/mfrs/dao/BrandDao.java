package com.shiguang.mfrs.dao;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.GoodsDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 品牌维护表
 *
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-17 18:07:13
 */
@Mapper
public interface BrandDao {

    //	BrandDO get(Integer brandid);
    //关联所有品牌维护所需表
    BrandDO getall(Integer brandid);

    List<BrandDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(BrandDO brand);

    int update(BrandDO brand);

    int remove(Integer brandid);

    int batchRemove(Integer[] brandids);

    //菜单联动显示
    List<GoodsDO> caidan(@Param("mfrsid") Integer mfrsid);
}
