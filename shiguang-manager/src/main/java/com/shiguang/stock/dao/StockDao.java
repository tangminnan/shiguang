package com.shiguang.stock.dao;


import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.PartsDO;
import com.shiguang.stock.domain.StockDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 库存表
 *
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-07-09 11:08:27
 */
@Mapper
public interface StockDao {


    StockDO get(Long id);

    List<StockDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(StockDO stock);

    int update(StockDO stock);

    int remove(Long id);

    int batchRemove(Long[] ids);

    List<StockDO> listJiajia(Map<String, Object> map);

    int countJiajia(Map<String, Object> map);

    List<StockDO> listJpcp(Map<String, Object> map);

    int countJpcp(Map<String, Object> map);

    List<StockDO> listJpdz(Map<String, Object> map);

    int countJpdz(Map<String, Object> map);

    List<StockDO> listJiajiapj(Map<String, Object> map);

    int countJiajiapj(Map<String, Object> map);

    List<StockDO> listTaiyj(Map<String, Object> map);

    int countTaiyj(Map<String, Object> map);

    List<StockDO> listHaocai(Map<String, Object> map);

    int countHaocai(Map<String, Object> map);

    List<StockDO> listLaohj(Map<String, Object> map);

    int countLaohj(Map<String, Object> map);

    List<StockDO> listShiguang(Map<String, Object> map);

    int countShiguang(Map<String, Object> map);

    List<StockDO> listHuly(Map<String, Object> map);

    int countHuly(Map<String, Object> map);

    List<StockDO> listZengpin(Map<String, Object> map);

    int countZengpin(Map<String, Object> map);

    List<StockDO> listYxdz(Map<String, Object> map);

    int countYxdz(Map<String, Object> map);

    PositionDO findPosition(Map<String, Object> map);

    StockDO getGoodsNum(String goodsNum);

    //<!--配件【商】【品】【查】【询】-->
    List<PartsDO> selectPj(Map<String, Object> map);
}
