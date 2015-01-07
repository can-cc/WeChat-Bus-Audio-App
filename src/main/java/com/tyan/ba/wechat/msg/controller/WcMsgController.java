package com.tyan.ba.wechat.msg.controller;

import com.tyan.ba.wechat.msg.recv.WxRecvMsg;
import com.tyan.ba.wechat.msg.send.WxSendMsg;

public interface WcMsgController {

	public abstract void reflection(WxRecvMsg msg, WxSendMsg sendMsg);
}
