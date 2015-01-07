package com.tyan.ba.wechat.msg.controller;

import java.util.Map;

public class TextInterrogatorAlpha implements TextInterrogator {

	//以后新增调整顺序功能！
	private Map<String, TextReflector> reflectors;
	
	public Map<String, TextReflector> getReflectors() {
		return reflectors;
	}

	public void setReflectors(Map<String, TextReflector> reflectors) {
		this.reflectors = reflectors;
	}

	@Override
	public String ask(String input, String usrId) {
		String response = null;
		for(TextReflector reflector : reflectors.values()){
			response = reflector.reflect(input, usrId);
			if(response != null)
				return response;
		}
		response = "亲，无效操作啊 ( •́ .̫ •̀ )，"
				+ "输入”专辑“查看专辑，"
				+ "“专辑&”查看专辑详细，"
				+ "看到听力音频后输入音频名称就可以收听啦，"
				+ "是不是很简单呢，"
				+ "萌萌哒！"; //以后改进
		return response;
	}

	@Override
	public void addReflector(TextReflector tReflector) {

	}

	@Override
	public void disableReflector(TextReflector tReflector) {

	}

	@Override
	public void ableReflector(TextReflector tReflector) {

	}

	@Override
	public void getReflector(String name) {

	}

	@Override
	public int reflectorSize() {
		return reflectors.size();
	}

}
