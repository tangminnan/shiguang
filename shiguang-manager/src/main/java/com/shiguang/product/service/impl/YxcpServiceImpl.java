package com.shiguang.product.service.impl;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.product.dao.YxcpDao;
import com.shiguang.product.domain.YxcpDO;
import com.shiguang.product.service.YxcpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class YxcpServiceImpl implements YxcpService {
    @Autowired
    private YxcpDao yxcpDao;

    @Override
    public YxcpDO get(Long id) {
        return yxcpDao.get(id);
    }

    @Override
    public List<YxcpDO> list(Map<String, Object> map) {
        return yxcpDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return yxcpDao.count(map);
    }

    @Override
    public int save(YxcpDO yxcp) {
        return yxcpDao.save(yxcp);
    }

    @Override
    public int update(YxcpDO yxcp) {
        return yxcpDao.update(yxcp);
    }

    @Override
    public int remove(Long id) {
        return yxcpDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return yxcpDao.batchRemove(ids);
    }



    //删除修改状态
    @Override
    public int updateState(YxcpDO yxcp) {
        return yxcpDao.updateState(yxcp);
    }

    //判断是否存在商品代码
    @Override
    public List<YxcpDO> haveNum(Map<String, Object> map) {
        return yxcpDao.haveNum(map);
    }

    @Override
    public YxcpDO getYxcpInfomation(String goodsNum) {
        return yxcpDao.getYxcpInfomation(goodsNum);
    }
}
