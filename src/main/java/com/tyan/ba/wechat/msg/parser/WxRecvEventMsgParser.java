package com.tyan.ba.wechat.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvEventMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvMsg;

public class WxRecvEventMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvEventMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		String event = getElementText(root, "Event");
		String eventKey = getElementText(root, "EventKey");
		
		return new WxRecvEventMsg(msg, event,eventKey);
	}

}
