package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.BrandDao;
import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public BrandDO getall(Integer brandid) {
        return brandDao.getall(brandid);
    }

    @Override
    public List<BrandDO> list(Map<String, Object> map) {
        return brandDao.list(map);
    }
    @Override
    public List<BrandDO> finfBrand(Map<String, Object> map) {
        return brandDao.finfBrand(map);
    }

    @Override
    public int finfBrandcount(Map<String, Object> map) {
        return brandDao.finfBrandcount(map);
    }
    @Override
    public List<BrandDO> haveNum(Map<String, Object> map) {
        return brandDao.haveNum(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return brandDao.count(map);
    }//选择制造商


    @Override
    public int save(BrandDO brand) {
        return brandDao.save(brand);
    }

    @Override
    public int update(BrandDO brand) {
        return brandDao.update(brand);
    }

    @Override
    public int remove(Integer brandid) {
        return brandDao.remove(brandid);
    }

    @Override
    public int batchRemove(Integer[] brandids) {
        return brandDao.batchRemove(brandids);
    }

    @Override
    public List<GoodsDO> caidan(Integer mfrsid) {
        return brandDao.caidan(mfrsid);
    }

    @Override
    public int updateState(BrandDO brand) {
        return brandDao.updateState(brand);
    }
}
