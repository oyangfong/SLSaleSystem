package org.slsale.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping("user/list")
   public String list() {
	   return "user/userlist";
   }
   
}
