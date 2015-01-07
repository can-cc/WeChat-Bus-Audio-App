package test;

import com.sina.sae.memcached.SaeMemcache;
import com.tyan.ba.game.textGame.Player;

public class TEST {
	public static void main(String[] args) {
		SaeMemcache mc = new SaeMemcache("127.0.0.1", 11211);
		mc.init();
		mc.set("aa", 9527);
		System.out.println(mc.get("aa"));
		Player player = new Player();
		System.out.println(player.xSize);
		mc.set("id", player);
		player.xSize = 35;
		Player player2 = mc.get("id");
		System.out.println(player2.xSize);
		

	}
}
