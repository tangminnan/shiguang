package com.shiguang.jiekou.service.impl;

import com.shiguang.jiekou.dao.SettlementJKDao;
import com.shiguang.jiekou.domain.SettlementJKDO;
import com.shiguang.jiekou.service.SettlementJKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SettlementJKServiceImpl implements SettlementJKService {
	@Autowired
	private SettlementJKDao settlementJKDao;

	@Override
	public List<SettlementJKDO> list(Map<String, Object> map) {
		return settlementJKDao.list(map);
	}
}
