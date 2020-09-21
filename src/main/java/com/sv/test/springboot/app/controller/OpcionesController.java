package com.sv.test.springboot.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sv.test.springboot.app.constant.ViewConstant;

@Controller
@RequestMapping("/opciones")
public class OpcionesController {
	
	private static final Log LOG = LogFactory.getLog(OpcionesController.class);	

	
	@GetMapping("/showOpciones")
	public ModelAndView showContacts() {
		ModelAndView mav = new ModelAndView(ViewConstant.OPCIONES);
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		
		return mav;
	}

}
