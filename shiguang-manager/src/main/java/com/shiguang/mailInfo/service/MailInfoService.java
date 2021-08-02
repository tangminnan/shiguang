package com.shiguang.mailInfo.service;

import com.shiguang.mailInfo.domain.MailInfoDO;

import java.util.List;
import java.util.Map;

public interface MailInfoService {
    MailInfoDO get(Long id);

    List<MailInfoDO> list(Map<String,Object> map);

    int count(Map<String,Object> map);

    int save(MailInfoDO info);

    int update(MailInfoDO info);

    int remove(Long id);

    int batchRemove(Long[] ids);

    MailInfoDO getMailAddress(String saleNumber);
}
