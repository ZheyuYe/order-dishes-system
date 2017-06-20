package com.softeem.web;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softeem.bean.MenuBean;
import com.softeem.bean.TypeBean;
import com.softeem.service.MenuService;
import com.softeem.service.TypeService;

/**
 * 处理与菜单相关的逻辑
 * 
 * @author Edward
 */
@Controller
@RequestMapping(value = "/menuController")
public class MenuController {

	@Resource(name = "menuService")
	private MenuService menuService;

	@Resource(name = "typeService")
	private TypeService typeService;

	@RequestMapping(value = "/getAllMenu.action")
	public @ResponseBody List<MenuBean> showAllMenu() {
		// 调用 service ,获取商品列表
		List<MenuBean> menuList = menuService.listAllMenu();

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}

	@RequestMapping(value = "/getMenuByType.action")
	public @ResponseBody List<MenuBean> getMenuByType(int typeId) {
		// 调用 service ,获取商品列表
		List<MenuBean> menuList = menuService.getMenuByType(typeId);

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}

	@RequestMapping(value = "/getMenuByMenuId.action")
	public @ResponseBody MenuBean getMenuById(int menuId) {
		// 调用 service ,获取商品列表
		MenuBean menu = menuService.getMenuById(menuId);

		System.out.println(menu);
		// 将商品列表以 json 形式返回到客户端
		return menu;
	}

	@RequestMapping(value = "/getAllType.action")
	public @ResponseBody List<TypeBean> getAllType() {
		// 调用 service ,获取商品列表
		List<TypeBean> typeList = typeService.listAllType();

		System.out.println(typeList);
		// 将商品列表以 json 形式返回到客户端
		return typeList;
	}

	@RequestMapping(value = "/searchByName.action")
	public @ResponseBody List<MenuBean> searchByName(String shortName) throws UnsupportedEncodingException {
		System.out.println(shortName);
		shortName = "%" + shortName + "%";

		// 调用 service ,获取商品列表
		List<MenuBean> menuList = menuService.searchByName(shortName);

		System.out.println(menuList);
		// 将商品列表以 json 形式返回到客户端
		return menuList;
	}

	public MenuService getMenuService() {
		return menuService;
	}

	public void setMenuService(MenuService menuService) {
		this.menuService = menuService;
	}

	public TypeService getTypeService() {
		return typeService;
	}

	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
	}

}
