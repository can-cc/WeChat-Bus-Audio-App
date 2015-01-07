package com.tyan.ba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ExceptionController {

	@RequestMapping(value={"/NotFindPage"}, method = RequestMethod.GET)
	String notFindPage(Model model){
		return "error/NotFindError";
	}
}
