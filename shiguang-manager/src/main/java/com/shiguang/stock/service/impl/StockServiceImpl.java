package com.shiguang.stock.service.impl;

import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.product.domain.PartsDO;
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

    //<!--配件【商】【品】【查】【询】-->
    @Override
    public List<PartsDO> selectPj(Map<String, Object> map) {
        return stockDao.selectPj(map);
    }

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
}
