package com.shiguang.system.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shiguang.common.domain.Tree;
import com.shiguang.system.domain.DeptDO;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.vo.UserVO;

@Service
public interface UserService {

	UserDO get(Long id);


	List<UserDO> getbyphone(String phone);

	List<UserDO> getRoleList(Map<String, Object> map);

	List<UserDO> getRoleNumList(Map<String, Object> map);

	List<UserDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	int save(UserDO user);

	int update(UserDO user);
	int sysupdate(UserDO user);
	
	int remove(Long userId);

	int batchremove(Long[] userIds);

	boolean exit(Map<String, Object> params);

	Set<String> listRoles(Long userId);

	List<UserDO> listManage(Map<String,Object> map);

	int countManage(Map<String,Object> map);

	List<UserDO> findListManages(Map<String,Object> map);

	int findCountManages(Map<String,Object> map);

	UserDO getUserName(Map<String,Object> map);

	int resetPwd(UserVO userVO,UserDO userDO) throws Exception;
	int adminResetPwd(UserVO userVO) throws Exception;
	Tree<DeptDO> getTree();

	/**
	 * 更新个人信息
	 * @param userDO
	 * @return
	 */
	int updatePersonal(UserDO userDO);

	/**
	 * 更新个人图片
	 * @param file 图片
	 * @param avatar_data 裁剪信息
	 * @param userId 用户ID
	 * @throws Exception
	 */
    Map<String, Object> updatePersonalImg(MultipartFile file, String avatar_data, Long userId) throws Exception;
}
