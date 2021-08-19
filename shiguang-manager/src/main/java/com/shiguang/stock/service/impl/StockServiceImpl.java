package com.shiguang.stock.service.impl;

import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.*;
import com.shiguang.stock.dao.StockDao;
import com.shiguang.stock.domain.StockDO;
import com.shiguang.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockDao stockDao;

    @Override
    public StockDO get(Long id) {
        return stockDao.get(id);
    }

    @Override
    public List<StockDO> list(Map<String, Object> map) {
        return stockDao.list(map);
    }


    @Override
    public int count(Map<String, Object> map) {
        return stockDao.count(map);
    }

    @Override
    public int save(StockDO stock) {
        return stockDao.save(stock);
    }

    @Override
    public int update(StockDO stock) {
        return stockDao.update(stock);
    }

    @Override
    public int remove(Long id) {
        return stockDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return stockDao.batchRemove(ids);
    }

    @Override
    public List<StockDO> listJiajia(Map<String, Object> map) {
        return stockDao.listJiajia(map);
    }

    @Override
    public int countJiajia(Map<String, Object> map) {
        return stockDao.countJiajia(map);
    }

    @Override
    public List<StockDO> listJpcp(Map<String, Object> map) {
        return stockDao.listJpcp(map);
    }

    @Override
    public int countJpcp(Map<String, Object> map) {
        return stockDao.countJpcp(map);
    }

    @Override
    public List<StockDO> listJpdz(Map<String, Object> map) {
        return stockDao.listJpdz(map);
    }

    @Override
    public int countJpdz(Map<String, Object> map) {
        return stockDao.countJpdz(map);
    }

    @Override
    public List<StockDO> listJiajiapj(Map<String, Object> map) {
        return stockDao.listJiajiapj(map);
    }

    @Override
    public int countJiajiapj(Map<String, Object> map) {
        return stockDao.countJiajiapj(map);
    }

    @Override
    public List<StockDO> listTaiyj(Map<String, Object> map) {
        return stockDao.listTaiyj(map);
    }

    @Override
    public int countTaiyj(Map<String, Object> map) {
        return stockDao.countTaiyj(map);
    }

    @Override
    public List<StockDO> listHaocai(Map<String, Object> map) {
        return stockDao.listHaocai(map);
    }

    @Override
    public int countHaocai(Map<String, Object> map) {
        return stockDao.countHaocai(map);
    }

    @Override
    public List<StockDO> listLaohj(Map<String, Object> map) {
        return stockDao.listLaohj(map);
    }

    @Override
    public int countLaohj(Map<String, Object> map) {
        return stockDao.countLaohj(map);
    }

    @Override
    public List<StockDO> listShiguang(Map<String, Object> map) {
        return stockDao.listShiguang(map);
    }

    @Override
    public int countShiguang(Map<String, Object> map) {
        return stockDao.countShiguang(map);
    }

    @Override
    public List<StockDO> listHuly(Map<String, Object> map) {
        return stockDao.listHuly(map);
    }

    @Override
    public int countHuly(Map<String, Object> map) {
        return stockDao.countHuly(map);
    }

    @Override
    public List<StockDO> listZengpin(Map<String, Object> map) {
        return stockDao.listZengpin(map);
    }

    @Override
    public int countZengpin(Map<String, Object> map) {
        return stockDao.countZengpin(map);
    }

    @Override
    public List<StockDO> listYxdz(Map<String, Object> map) {
        return stockDao.listYxdz(map);
    }

    @Override
    public int countYxdz(Map<String, Object> map) {
        return stockDao.countYxdz(map);
    }

    @Override
    public PositionDO findPosition(Map<String, Object> map) {
        return stockDao.findPosition(map);
    }

    @Override
    public StockDO getGoodsNum(String goodsNum) {
        return stockDao.getGoodsNum(goodsNum);
    }

    //<!--镜架【商】【品】【查】【询】-->
    @Override
    public List<ProducaDO> selectJingjia(Map<String, Object> map) {
        return stockDao.selectJingjia(map);
    }

    //<!--配件【商】【品】【查】【询】-->
    @Override
    public List<PartsDO> selectPeijian(Map<String, Object> map) {
        return stockDao.selectPeijian(map);
    }

    //<!--镜片定做【商】【品】【查】【询】-->
    @Override
    public List<JpdzDO> selectJpdz(Map<String, Object> map) {
        return stockDao.selectJpdz(map);
    }

    //<!--镜片成品【商】【品】【查】【询】-->
    @Override
    public List<JpcpDO> selectJpcp(Map<String, Object> map) {
        return stockDao.selectJpcp(map);
    }

    //<!--隐形定做【商】【品】【查】【询】-->
    @Override
    public List<YxdzDO> selectYxdz(Map<String, Object> map) {
        return stockDao.selectYxdz(map);
    }

    //<!--隐形成品【商】【品】【查】【询】-->
    @Override
    public List<YxcpDO> selectYxcp(Map<String, Object> map) {
        return stockDao.selectYxcp(map);
    }

    //<!--护理液【商】【品】【查】【询】-->
    @Override
    public List<HlyDO> selectHly(Map<String, Object> map) {
        return stockDao.selectHly(map);
    }

    //<!--太阳镜【商】【品】【查】【询】-->
    @Override
    public List<TyjDO> selectTyj(Map<String, Object> map) {
        return stockDao.selectTyj(map);
    }

    //<!--老花镜【商】【品】【查】【询】-->
    @Override
    public List<OldlensDO> selectLhj(Map<String, Object> map) {
        return stockDao.selectLhj(map);
    }

    //<!--耗材【商】【品】【查】【询】-->
    @Override
    public List<HcDO> selectHc(Map<String, Object> map) {
        return stockDao.selectHc(map);
    }

    //<!--视光【商】【品】【查】【询】-->

    @Override
    public List<ShiguangDO> selectSg(Map<String, Object> map) {
        return stockDao.selectSg(map);
    }

    @Override
    public int updateGoodsCount(StockDO stock) {
        return stockDao.updateGoodsCount(stock);
    }
    //判断是否存在商品信息


    @Override
    public StockDO haveNum(StockDO stockDO) {
        return stockDao.haveNum(stockDO);
    }

    //    【库存查询】
    @Override
    public List<StockDO> kccxList(Map<String, Object> map) {
        return stockDao.kccxList(map);
    }
}
