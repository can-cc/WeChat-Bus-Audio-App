package com.tyan.ba.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tyan.ba.entity.audio.Audio;
import com.tyan.ba.entity.category.Category;
import com.tyan.ba.wechat.msg.controller.TextInterrogator;
import com.tyan.ba.dao.CategoryDao;



@Controller
@RequestMapping("/test") 
public class TestController {
	@Autowired
	private ApplicationContext appContext;//自动装配ApplicationContext
	@Autowired
	private TextInterrogator textInterrogator;
	
	@RequestMapping(method = RequestMethod.GET)
	String home(Model model){
		
		//!!//model.addAttribute("timeUrl","1;url=index.jsp");
		System.out.println("-------------------------------");
		String[] inputs = {"专辑","bbs1","happy","bbs2","oop4","fuk","bbs1","专辑","专辑&"};
		for(String input : inputs){
			System.out.println(textInterrogator.ask(input, "113"));
			System.out.println();
		}

		return "util/timingJump";
	}
}
