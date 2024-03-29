package com.shiguang.stock.dao;


import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.*;
import com.shiguang.stock.domain.OrderDO;
import com.shiguang.stock.domain.StockDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    int remove(Long id );

    int batchRemove(Long[] ids);

    int updateStockCCount(StockDO stockDO);

    int updateStockCountNum(StockDO stockDO);

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

    List<StockDO> listShiguangdz(Map<String,Object> map);

    int countShiguangdz(Map<String,Object> map);

    List<StockDO> listHuly(Map<String, Object> map);

    int countHuly(Map<String, Object> map);

    List<StockDO> listZengpin(Map<String, Object> map);

    int countZengpin(Map<String, Object> map);

    List<StockDO> listYxcp(Map<String, Object> map);

    int countYxcp(Map<String, Object> map);

    List<StockDO> listYxdz(Map<String, Object> map);

    int countYxdz(Map<String, Object> map);

    PositionDO findPosition(Map<String, Object> map);

    PositionDO findHegePosition(Map<String, Object> map);

    PositionDO findBuHegePosition(Map<String, Object> map);

    StockDO getGoodsNum(String goodsNum);

    List<ProducaDO> selectJingjia(Map<String, Object> map);
    int selectJingjiaCount(Map<String, Object> map);
    List<PartsDO> selectPeijian(Map<String, Object> map);
    int selectPeijianCount(Map<String, Object> map);
    List<JpdzDO> selectJpdz(Map<String, Object> map);
    int selectJpdzCount(Map<String, Object> map);
    List<JpcpDO> selectJpcp(Map<String, Object> map);
    int selectJpcpCount(Map<String, Object> map);
    List<YxdzDO> selectYxdz(Map<String, Object> map);
    int selectYxdzCount(Map<String, Object> map);
    List<YxcpDO> selectYxcp(Map<String, Object> map);
    int selectYxcpCount(Map<String, Object> map);
    List<HlyDO> selectHly(Map<String, Object> map);
    int selectHlyCount(Map<String, Object> map);
    List<TyjDO> selectTyj(Map<String, Object> map);
    int selectTyjCount(Map<String, Object> map);
    List<OldlensDO> selectLhj(Map<String, Object> map);
    int selectLhjCount(Map<String, Object> map);
    List<HcDO> selectHc(Map<String, Object> map);
    int selectHcCount(Map<String, Object> map);
    List<ShiguangDO> selectSg(Map<String, Object> map);
    int selectSgCount(Map<String, Object> map);

    List<ShiguangdzDO> selectSgdz(Map<String, Object> map);
    int selectSgdzCount(Map<String, Object> map);

    //查询该条码的库存数量
    StockDO getProduceCode(StockDO stockDO);

    StockDO getProduceCodeCount(StockDO stockDO);

    //查询该代码的库存数量
    StockDO getProduceNum(StockDO stockDO);

    //修改库存数量
    int updateGoodsCount(StockDO stockDO);

    StockDO haveNum(StockDO stockDO);
    StockDO haveCountNum(StockDO stockDO);
    List<StockDO> kccxList(Map<String, Object> map);
    int countall(Map<String, Object> map);
    int kccxListCount(Map<String, Object> map);
    List<StockDO> codeBatch(Map<String, Object> map);

    int updateStatus(StockDO stock);

    int outPosionJ(StockDO stockDO);

    OrderDO getOeder(String danjuNumber);
    List<OrderDO> getOederList(Map<String, Object> map);

    OrderDO getShouhuo(String danjuNumber);
    List<OrderDO> getShouhuoList(Map<String, Object> map);


    StockDO jingjias(StockDO stockDO);
    StockDO peijians(StockDO stockDO);
    StockDO jingpians(StockDO stockDO);
    StockDO yinxings(StockDO stockDO);
    StockDO jingpiandzs(StockDO stockDO);
    StockDO yinxingdzs(StockDO stockDO);
    StockDO huliyes(StockDO stockDO);
    StockDO taiyangjings(StockDO stockDO);
    StockDO laohuajings(StockDO stockDO);
    StockDO haocais(StockDO stockDO);
    StockDO shiguangs(StockDO stockDO);
}
