//package com.tyan.ba.game.textGame;
//
//import com.sina.sae.memcached.SaeMemcache;
//
//public class TextGameControllerAlpha implements TextGameController{
//
//	private static SaeMemcache mc;
//	private static Entironment env = new Entironment();
//	static {
//		mc = new SaeMemcache();
//		mc.init();
//	}
//	static String start(){
//		Player player = null;
//		if(mc.get(uid+"tg") != null){
//			player = mc.get(uid+"tg");
//		} else {
//			player = new Player();
//		}
//		return env.commands(player);
//	}
//	
//	static String  reflect(long uid, String command){
//		Player player = null;
//		if(mc.get(uid+"tg") != null){
//			player = mc.get(uid+"tg");
//		} else {
//			player = new Player();
//		}
//		
//		
//	}
//}
