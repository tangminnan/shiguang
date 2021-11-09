package com.shiguang.product.dao;

import com.shiguang.mfrs.domain.BrandDO;
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
    int count(Map<String, Object> map);
    //选择护理液
    List<HlyDO> gethly(Map<String, Object> map);
    int gethlycount(Map<String, Object> map);

    int save(HlyDO hly);

    int update(HlyDO hly);

    int remove(Long id);

    int batchRemove(Long[] ids);


    //菜单联动显示
    List<BrandDO> choice(@Param("mfrsid") Integer mfrsid);

    //删除修改状态
    int updateState(HlyDO hly);
    //判断是否存在商品代码
    List<HlyDO> haveNum(Map<String, Object> map);

    HlyDO getHlyInfomation(String goodNum);
}
