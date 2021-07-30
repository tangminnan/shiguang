package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.MfrsDao;
import com.shiguang.mfrs.domain.MfrsDO;
import com.shiguang.mfrs.service.MfrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class MfrsServiceImpl implements MfrsService {
    @Autowired
    private MfrsDao mfrsDao;

    @Override
    public MfrsDO get(Integer mfrsid) {
        return mfrsDao.get(mfrsid);
    }

    //判断是否存在制造商代码
    @Override
    public List<MfrsDO> haveNum(Map<String, Object> map) {
        return mfrsDao.haveNum(map);
    }

    //	---商品查询----
    @Override
    public List<MfrsDO> list(Map<String, Object> map) {
        return mfrsDao.list(map);
    }

    //    <!--查询镜架制造商-->
    @Override
    public List<MfrsDO> producaList(Map<String, Object> map) {
        return mfrsDao.producaList(map);
    }

    //    <!--查询配件制造商-->
    @Override
    public List<MfrsDO> partsList(Map<String, Object> map) {
        return mfrsDao.partsList(map);
    }

    //查询镜片成片制造商
    @Override
    public List<MfrsDO> jpcpList(Map<String, Object> map) {
        return mfrsDao.jpcpList(map);
    }

    //    <!--查询隐形成片制造商-->
    @Override
    public List<MfrsDO> yxcpList(Map<String, Object> map) {
        return mfrsDao.yxcpList(map);
    }
    //    <!--查询护理液制造商-->

    @Override
    public List<MfrsDO> hlyList(Map<String, Object> map) {
        return mfrsDao.hlyList(map);
    }

    // <!--查询太阳镜制造商-->


    @Override
    public List<MfrsDO> tyjList(Map<String, Object> map) {
        return mfrsDao.tyjList(map);
    }

    //    <!--查询老花镜制造商-->

    @Override
    public List<MfrsDO> oldlensList(Map<String, Object> map) {
        return mfrsDao.oldlensList(map);
    }


    //    <!--查询耗材制造商-->

    @Override
    public List<MfrsDO> hcList(Map<String, Object> map) {
        return mfrsDao.hcList(map);
    }


    //    <!--查询视光制造商-->

    @Override
    public List<MfrsDO> shiguangList(Map<String, Object> map) {
        return mfrsDao.shiguangList(map);
    }

    @Override
    public int mgcount(Map<String, Object> map) {
        return mfrsDao.mgcount(map);
    }

    @Override
    public int save(MfrsDO mfrs) {
        return mfrsDao.save(mfrs);
    }

    //修改停用启用
    @Override
    public int update(MfrsDO mfrs) {
        return mfrsDao.update(mfrs);
    }

    @Override
    public int remove(Integer mfrsid) {
        return mfrsDao.remove(mfrsid);
    }

    @Override
    public int batchRemove(Integer[] mfrsids) {
        return mfrsDao.batchRemove(mfrsids);
    }

    //删除修改状态
    @Override
    public int updateState(MfrsDO mfrs) {
        return mfrsDao.updateState(mfrs);
    }
}
