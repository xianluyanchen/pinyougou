package com.pinyougou.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pinyougou.pojo.TbSeller;
import com.pinyougou.sellergoods.service.SellerService;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	 private SellerService sellerService; 
	 
	 public void setSellerService(SellerService sellerService) { 
	  this.sellerService = sellerService; 
	 } 


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>(); 
		grantedAuths.add(new SimpleGrantedAuthority("ROLE_SELLER")); 
		System.out.println("通过了安全认证器");
		System.out.println(username);
		//username 就是id主键
		TbSeller findOne = sellerService.findOne(username);
		System.out.println(findOne.getSellerId()+"===="+findOne.getPassword());
		if(findOne != null && findOne.getStatus().equals("1")) {
			return new User(username,findOne.getPassword(),grantedAuths);
		}else {
			return null;
		}
	}

}
