package com.tyan.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/web")
public class WebController {
	@Autowired
	private ApplicationContext appContext;
	
	@RequestMapping(value = "/{categoryId}/{audioName}", method = RequestMethod.GET)
	String audioVeiw(){
		return null;
	}
}
