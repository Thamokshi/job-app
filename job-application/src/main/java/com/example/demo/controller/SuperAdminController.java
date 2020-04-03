package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/superadmin**")
public class SuperAdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "superadmin/index";
	}

}