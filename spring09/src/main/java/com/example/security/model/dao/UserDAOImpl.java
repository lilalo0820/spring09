package com.example.security.model.dao;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	@Inject
	SqlSession sqlSession;
	 
	@Override
	public int insert(Map<String, Object> map) {
		return sqlSession.insert("user.insert",map);
	}

	@Override
	public Map<String, Object> detail(String userid) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("user.detail", userid);
	}

}
