package wechat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sina.sae.memcached.SaeMemcache;
import com.tyan.ba.wechat.msg.controller.EnglishAudioReflector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class EnglishAudioReflectorTest {
	
	@Resource
	private EnglishAudioReflector englishAudioReflector;
	
	@Test
	public void reflectTest(){
		SaeMemcache mc = new SaeMemcache(); 
		mc.init();
		//System.out.println(mc.get("231"));
		System.out.println(englishAudioReflector.reflect("听力专辑&描述", "231"));
		//System.out.println(englishAudioReflector.reflect("bbs1", "113"));
	}

}
