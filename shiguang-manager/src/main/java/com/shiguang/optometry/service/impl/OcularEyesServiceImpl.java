package com.shiguang.optometry.service.impl;

import com.shiguang.member.domain.MemberDO;
import com.shiguang.optometry.dao.OcularEyesDao;
import com.shiguang.optometry.domain.OcularEyesDO;
import com.shiguang.optometry.service.OcularEyesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OcularEyesServiceImpl implements OcularEyesService {
    @Autowired
    private OcularEyesDao eyesDao;

    @Override
    public OcularEyesDO get(Long id) {
        return eyesDao.get(id);
    }

    @Override
    public List<OcularEyesDO> list(Map<String, Object> map) {
        return eyesDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map) {
        return eyesDao.count(map);
    }

    @Override
    public int save(OcularEyesDO eyes) {
        return eyesDao.save(eyes);
    }

    @Override
    public int update(OcularEyesDO eyes) {
        return eyesDao.update(eyes);
    }

    @Override
    public int remove(Long id) {
        return eyesDao.remove(id);
    }

    @Override
    public int batchRemove(Long[] ids) {
        return eyesDao.batchRemove(ids);
    }

    @Override
    public List<MemberDO> findOptoEyesList(Map<String, Object> map) {return eyesDao.findOptoEyesList(map);}

    @Override
    public int findOptoEyesCount(Map<String, Object> map) {
        return eyesDao.findOptoEyesCount(map);
    }
}
