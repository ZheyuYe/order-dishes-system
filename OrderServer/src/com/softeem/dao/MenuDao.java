package com.softeem.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.softeem.bean.MenuBean;

@Repository(value="menuDao")
public interface MenuDao {
	
	List<MenuBean> selectAllMenu();
	
	MenuBean selectById(long menuId);
	
	List<MenuBean> selectByType(int typeId);

	List<MenuBean> selectLikeName(String shortName);
}
