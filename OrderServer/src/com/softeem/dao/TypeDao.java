package com.softeem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softeem.bean.MenuBean;
import com.softeem.bean.TypeBean;

@Repository(value="typeDao")
public interface TypeDao {
	
	List<TypeBean> selectAllType();
	
	TypeBean selectById(int typeId);
	
}
