package com.shiguang.mailInfo.dao;

import com.shiguang.mailInfo.domain.MailInfoDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MailInfoDao {
    MailInfoDO get(Long id);

    List<MailInfoDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(MailInfoDO info);

    int update(MailInfoDO info);

    int remove(Long id);

    int batchRemove(Long[] ids);
}
