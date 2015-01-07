package com.tyan.ba.wechat.msg.parser;

import org.jdom.Element;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.recv.WxRecvPicMsg;

public class WxRecvPicMsgParser extends WxRecvMsgBaseParser {

	@Override
	protected WxRecvPicMsg parser(Element root, WxRecvMsg msg) throws JDOMException {
		return new WxRecvPicMsg(msg, getElementText(root, "PicUrl"));
	}

}
