package com.softeem.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.softeem.bean.MenuBean;
import com.softeem.dao.MenuDao;

@Service(value = "menuService")
public class MenuService {
	@Resource(name = "menuDao")
	private MenuDao menuDao;

	public List<MenuBean> listAllMenu() {
		return menuDao.selectAllMenu();
	}

	public MenuBean getMenuById(int menuId) {
		return menuDao.selectById(menuId);
	}

	public List<MenuBean> getMenuByType(int typeId) {
		return menuDao.selectByType(typeId);
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public List<MenuBean> searchByName(String shortName) {
		return menuDao.selectLikeName(shortName);
	}

}
