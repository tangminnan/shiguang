package com.shiguang.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.shiguang.common.domain.LogDO;
import com.shiguang.common.domain.PageDO;
import com.shiguang.common.utils.Query;
@Service
public interface LogService {
	void save(LogDO logDO);
	PageDO<LogDO> queryList(Query query);
	int remove(Long id);
	int batchRemove(Long[] ids);
}
