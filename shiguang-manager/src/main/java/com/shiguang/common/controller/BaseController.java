package com.shiguang.common.controller;

import org.springframework.stereotype.Controller;

import com.shiguang.common.utils.ShiroUtils;
import com.shiguang.system.domain.UserDO;
import com.shiguang.system.domain.UserToken;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}