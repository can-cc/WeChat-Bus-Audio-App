package com.tyan.ba.wechat.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvVoiceMsg;

public class WxRecvVoiceMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvVoiceMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String event = getElementText(root, "Event");
		String eventKey = getElementText(root, "EventKey");
		
		return new WxRecvVoiceMsg(msg, event,eventKey);
	}

}
