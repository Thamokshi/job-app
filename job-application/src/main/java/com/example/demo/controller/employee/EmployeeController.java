package com.example.demo.controller.employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee**")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "employee/index";
	}

}