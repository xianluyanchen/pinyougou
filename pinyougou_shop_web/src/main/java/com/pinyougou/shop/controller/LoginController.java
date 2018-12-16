package com.pinyougou.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
@ResponseBody
public class LoginController {

	@RequestMapping("/getLoginName")
	public Map<String, String> getLoginName() {
		String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
		Map<String, String> map = new HashMap<>();
		map.put(loginName, loginName);
		return map;
	}
}
