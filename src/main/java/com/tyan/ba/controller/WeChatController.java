package com.tyan.ba.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tyan.ba.http.HttpServletResponseCharset;
import com.tyan.ba.wechat.ValidateModel;
import com.tyan.ba.wechat.ValidateTool;
import com.tyan.ba.wechat.msg.WechatMsgService;
import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.send.WxSendMsg;


@Controller
@RequestMapping("/wechat")  
public class WeChatController {
	
	@Autowired
	private ApplicationContext appContext;//自动装配ApplicationContext
	
	private static final String TOKEN = "tyanBusAudioServer";


	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody String validate(ValidateModel vmodel){
		return ValidateTool.validate(vmodel, TOKEN);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	void reflection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpServletResponseCharset hsrc = (HttpServletResponseCharset) appContext.getBean("httpServletResponseCharset");
		hsrc.CharsetAdjust(response);//设置编码utf-8
		try {
			WxRecvMsg msg = WechatMsgService.recv(request.getInputStream());
			WxSendMsg sendMsg = WechatMsgService.builderSendByRecv(msg);
		} catch (Exception e) {
			e.printStackTrace();
			//！！！以后封装自定义异常
		}
	}
}
