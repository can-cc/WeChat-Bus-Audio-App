package com.tyan.ba.wechat.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvLinkMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvMsg;

public class WxRecvLinkMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvLinkMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		
		String title = getElementText(root, "Title");
		String description = getElementText(root, "Description");
		String url = getElementText(root, "Url");
		return new WxRecvLinkMsg(msg, title, description, url);
	}

}
