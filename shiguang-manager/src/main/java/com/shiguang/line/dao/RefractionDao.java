package com.shiguang.line.dao;


import com.shiguang.common.utils.R;
import com.shiguang.line.domain.RefractionDO;
import com.shiguang.line.domain.RefractionLineDO;
import com.shiguang.line.domain.RefractionLineMemberDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.logging.log4j.core.appender.rolling.RolloverFrequency;

import java.util.List;
import java.util.Map;

/**
 * 排队列表
 * @author wjl
 * @email bushuo@163.com
 * @date 2021-09-15 14:09:10
 */
@Mapper
public interface RefractionDao {

	RefractionLineDO get(Long id);

	RefractionDO getRefraction(String name);

	List<RefractionLineDO> list(Map<String, Object> map);

	List<RefractionLineDO> refrationlineList(Map<String,Object> map);

	List<RefractionLineDO> refrationlinesList(Map<String,Object> map);

	List<RefractionLineMemberDO> listMember(Map<String,Object> map);

	int count(Map<String, Object> map);

	int save(RefractionDO line);

	int saveLine(RefractionLineDO refractionLineDO);

	int saveLineMember(RefractionLineMemberDO refractionLineMemberDO);

	int update(RefractionDO line);

	int updateLine(RefractionLineDO refractionLineDO);

	int remove(String name);

	int batchRemove(Long[] ids);

	int updateByMember(RefractionDO RefractionDO);

	List<RefractionDO> lineList(Map<String, Object> map);

	int removeMember(Long id);
}
