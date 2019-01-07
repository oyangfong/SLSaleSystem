package org.slsale.pojo;

import java.util.List;
/**
 * Menu
 * 菜单
 */
public class Menu{

	private Function mainMenu;//主功能菜单项
	private List<Function> subMenus;//子功能菜单项列表

	public List<Function> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<Function> subMenus) {
		this.subMenus = subMenus;
	}

	public Function getMainMenu() {
		return mainMenu;
	}

	public void setMainMenu(Function mainMenu) {
		this.mainMenu = mainMenu;
	}
	
}
