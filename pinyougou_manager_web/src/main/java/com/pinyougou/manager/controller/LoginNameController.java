package com.pinyougou.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@RequestMapping("/login")
@Controller
public class LoginNameController {
	
	@RequestMapping("/getName")
	public Map<String, String> getUsername(){
		Map<String, String> map = new HashMap<String,String>();
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		map.put("loginName", username);
		return map;
	}
}
