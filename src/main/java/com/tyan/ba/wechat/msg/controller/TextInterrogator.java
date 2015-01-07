package com.tyan.ba.wechat.msg.controller;

public interface TextInterrogator {
	
	
	public String ask(String input, String usrId);
	public void addReflector(TextReflector tReflector);
	public void disableReflector(TextReflector tReflector);
	public void ableReflector(TextReflector tReflector);
	public void getReflector(String name);
	public int reflectorSize();

}
