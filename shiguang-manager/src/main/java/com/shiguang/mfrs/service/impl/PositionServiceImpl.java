package com.shiguang.mfrs.service.impl;

import com.shiguang.mfrs.dao.PositionDao;
import com.shiguang.mfrs.domain.PositionDO;
import com.shiguang.mfrs.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    @Override
    public PositionDO get(Long positionId) {
        return positionDao.get(positionId);
    }

    @Override
    public List<PositionDO> haveNum(Map<String, Object> map) {
        return positionDao.haveNum(map);
    }

    @Override
    public List<PositionDO> list(Map<String, Object> map) {
        return positionDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return positionDao.count(map);
    }

    @Override
    public int save(PositionDO position) {
        return positionDao.save(position);
    }

    //修改停用启用
    @Override
    public int update(PositionDO position) {
        return positionDao.update(position);
    }

    @Override
    public int remove(Long positionId) {
        return positionDao.remove(positionId);
    }

    @Override
    public int batchRemove(Long[] positionIds) {
        return positionDao.batchRemove(positionIds);
    }

    //删除修改状态
    @Override
    public int updateState(PositionDO position) {
        return positionDao.updateState(position);
    }

    @Override
    public PositionDO getPositionNum(String positionNum) {
        return positionDao.getPositionNum(positionNum);
    }

    //     <!--库存查询相对应的仓库-->
    @Override
    public List<PositionDO> positionList(Map<String, Object> map) {
        return positionDao.positionList(map);
    }
}
