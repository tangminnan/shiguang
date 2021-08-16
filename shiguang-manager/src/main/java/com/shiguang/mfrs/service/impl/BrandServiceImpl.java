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

    //关联所有品牌维护所需表
    @Override
    public BrandDO getall(Integer brandid) {
        return brandDao.getall(brandid);
    }

    @Override
    public List<BrandDO> list(Map<String, Object> map) {
        return brandDao.list(map);
    }
    //    <!--查询商品品种-->
    @Override
    public List<BrandDO> finfBrand(Map<String, Object> map) {
        return brandDao.finfBrand(map);
    }
    //    <!--//判断是否存在制造商代码-->
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

    //修改停用启用
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

    //菜单联动显示
    @Override
    public List<GoodsDO> caidan(Integer mfrsid) {
        return brandDao.caidan(mfrsid);
    }
    //删除修改状态

    @Override
    public int updateState(BrandDO brand) {
        return brandDao.updateState(brand);
    }
}
