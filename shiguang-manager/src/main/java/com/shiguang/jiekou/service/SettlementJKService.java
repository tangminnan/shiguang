package com.shiguang.jiekou.service;


import com.shiguang.jiekou.domain.SettlementJKDO;

import java.util.List;
import java.util.Map;

/**
 * 结款管理
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-06-17 11:27:49
 */
public interface SettlementJKService {

	List<SettlementJKDO> list(Map<String, Object> map);


}
