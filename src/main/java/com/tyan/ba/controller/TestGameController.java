package com.tyan.ba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tyan.ba.wechat.msg.controller.TextInterrogator;

@Controller
@RequestMapping("/testGame") 
public class TestGameController {
	@Autowired
	private ApplicationContext appContext;//自动装配ApplicationContext
	@Autowired
	private TextInterrogator textInterrogator;
	
	@RequestMapping(method = RequestMethod.GET)
	String view(Model model){
		return "textGame/gameTest";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody String commandReflect(@RequestParam("pid") long pid,
			@RequestParam("command") String command) {
		System.out.println(pid+command);
		return "hahah";
	}
}
