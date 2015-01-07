package com.tyan.ba.wechat.msg.parser;

import org.jdom.Document;
import org.jdom.JDOMException;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;

public interface WxRecvMsgParser {
	WxRecvMsg parser(Document doc) throws JDOMException;
}
