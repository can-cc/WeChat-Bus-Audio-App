package wechat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tyan.ba.wechat.msg.controller.TextInterrogator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class InterrogatorTest {
	@Resource
	private TextInterrogator textInterrogator;
	
	@Test
	public void askTest(){
		String[] inputs = {"专辑","bbs1","happy","bbs2","oop4","fuk","bbs1","专辑","专辑&"};
		for(String input : inputs){
			System.out.println(textInterrogator.ask(input, "113"));
			System.out.println();
		}
	}
	
}
