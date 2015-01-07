package com.tyan.ba.wechat.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvTextMsg;

public class WxRecvTextMsgParser extends WxRecvMsgBaseParser{

	@Override
	protected WxRecvTextMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvTextMsg(msg, getElementText(root, "Content"));
	}

	
}
