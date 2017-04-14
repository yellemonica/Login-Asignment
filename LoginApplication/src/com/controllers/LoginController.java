package com.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.LoginBean;
import com.services.LoginService;

@Controller
@RequestMapping("loginform.html")
public class LoginController {

	@Autowired
	public LoginService loginService;

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginBean loginForm = new LoginBean();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Valid LoginBean loginForm, BindingResult result, Map model) {

		if (result.hasErrors()) {
			return "loginform";
		}
		boolean userExists = loginService.checkLogin(loginForm.getId(), loginForm.getuserName());
		if (userExists) {
			model.put("loginForm", loginForm);
			return "loginsuccess";
		} else {
			result.rejectValue("userName", "invaliduser");
			return "loginform";
		}

	}

}
