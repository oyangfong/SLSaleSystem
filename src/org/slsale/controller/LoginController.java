package org.slsale.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slsale.pojo.Authority;
import org.slsale.pojo.Function;
import org.slsale.pojo.Menu;
import org.slsale.pojo.User;
import org.slsale.service.function.FunctionService;
import org.slsale.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
	
	@Resource
	private FunctionService functionService;
	
	@RequestMapping("/login.html")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("/login")
	public String login(User user,HttpSession session) {
		// 调用完业务类以后的处理情况		
		User ret;
		try {
			ret = userService.login(user);
			if (ret!=null) {
				//保存登录用户到session
				session.setAttribute("loginUser", ret);
				return "redirect:index";
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "login";

	}
	
	@RequestMapping("/index")
	public String index(Model model,HttpSession session){
		User user=(User)session.getAttribute("loginUser");
		//根据用户的角色id,调用业务类的方法抓取菜单
		List<Menu> menuList=getFuncByCurrentUser(user.getRoleId());
		model.addAttribute("mList", menuList);
		return "index";
	}
	
	/**
	 * 根据用户角色id,获取功能模块列表，用于构建页面左边导航菜单
	 */	
	public List<Menu> getFuncByCurrentUser(int roleId){
		List<Menu> menuList=new ArrayList<Menu>();
		
		Authority authority=new Authority();
		authority.setRoleId(roleId);
		
		try {
			//抓取一级菜单列表
			List<Function> mainFunctionList=functionService.getMainFunctionList(authority);
			
			if(null!=mainFunctionList){
				for (Function function : mainFunctionList) {
					//实例化Menu
					Menu menu=new Menu();
					menu.setMainMenu(function);
					
					//设置查询条件
					function.setRoleId(roleId);
					//根据主菜单项获取其子菜单列表
					List<Function> subFunctionList=functionService.getSubFunctionList(function);
					if(null!=subFunctionList){ menu.setSubMenus(subFunctionList);}
					
					//将Menu菜单对象放入集合中
					menuList.add(menu);
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}
}
