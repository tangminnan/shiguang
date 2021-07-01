package com.shiguang.product.service;

import com.shiguang.mfrs.domain.BrandDO;
import com.shiguang.mfrs.domain.GoodsDO;
import com.shiguang.mfrs.domain.MgDO;
import com.shiguang.product.domain.ProducaDO;

import java.util.List;
import java.util.Map;

/**
 * 镜架新增表
 * 
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-25 18:06:25
 */
public interface ProducaService {
	
	ProducaDO get(Long id);
	
	List<MgDO> mglist(Map<String, Object> map);
	List<ProducaDO> list(Map<String, Object> map);

	List<ProducaDO> listmateria(Map<String,Object> map);
	int countmateria(Map<String, Object> map);
	int count(Map<String, Object> map);
	
	int save(ProducaDO produca);
	
	int update(ProducaDO produca);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
	//菜单联动显示
	List<BrandDO> choice(Integer mfrsid);
}
