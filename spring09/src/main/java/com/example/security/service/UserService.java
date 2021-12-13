package com.example.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.security.model.dto.UserDTO;


//UserDetailsService 스프링제공 security에서 상속
public class UserService implements UserDetailsService{

	@Inject
	SqlSessionTemplate sqlSession;
	
	public UserService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
 
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		Map<String, Object> user = sqlSession.selectOne("user.detail", userid);
		if(user == null) {
			throw new UsernameNotFoundException(userid);
		}
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString()));
		
		return new UserDTO(
					user.get("USERNAME").toString(),
					user.get("PASSWORD").toString(),
					(Integer)Integer.valueOf(user.get("ENABLED").toString())== 1
					, true
					, true
					, true
					, authority
					,user.get("USERNAME").toString()
				);
	}

} 
