package com.example.demo.controller.admin;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin-panel")
public class AdminLoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "redirect:/admin-panel/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(
		@RequestParam(value = "error", required = false) String error,
		@RequestParam(value = "logout", required = false) String logout,
		ModelMap modelMap) {
		if(error != null) {
			modelMap.put("msg", "Invalid usernme or password");
		}
		if(logout != null) {
			modelMap.put("msg", "Logout successfully");
		}
		return "admin/login";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "redirect:/admin-panel/login?logout";
	}

	@RequestMapping(value = "accessDenied", method = RequestMethod.GET)
	public String accessDenied(Authentication authentication, ModelMap modelMap) {
		if(authentication != null) {
			modelMap.put("msg", "Hi " + authentication.getName() + ", you do not have permission to access this page!");
		} else {
			modelMap.put("msg", "You do not have permission to access this page!");
		}
		return "admin/accessDenied";
	}

	@RequestMapping(value = "welcome", method = RequestMethod.GET)
	public String welcome() {
		return "admin/welcome";
	}
}
