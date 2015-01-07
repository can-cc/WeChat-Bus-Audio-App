package com.tyan.ba.wechat.msg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvTextMsg;
import com.tyan.ba.wechat.msg.send.WxSendMsg;

public class WcMsgControllerAlpha implements WcMsgController {
	@Autowired
	private ApplicationContext appContext;

	@Override
	public void reflection(WxRecvMsg msg, WxSendMsg sendMsg) {
		try {
			
			if (msg instanceof WxRecvTextMsg) {
				
				String input = ((WxRecvTextMsg) msg).getContent();
				String usrId = msg.getFromUser();
			//	String output = 
			} else {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
