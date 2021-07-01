package com.shiguang.product.dao;

import com.shiguang.product.domain.StyleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 款式表
 * @author cln
 * @email bushuo@163.com
 * @date 2021-06-30 09:53:22
 */
@Mapper
public interface StyleDao {

	StyleDO get(Long styleId);
	
	List<StyleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(StyleDO style);
	
	int update(StyleDO style);
	
	int remove(Long style_id);
	
	int batchRemove(Long[] styleIds);
}
