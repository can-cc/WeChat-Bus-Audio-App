package serviceTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tyan.ba.entity.audio.Audio;
import com.tyan.ba.entity.audio.AudioService;
import com.tyan.ba.vo.AudioUK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class AuidoServiceTest {
	@Resource
    private AudioService audioService;
	
	@Test
	public void findOneTest(){
		AudioUK audioUK = new AudioUK("sdaw",1);
		Audio audio = audioService.findOne(audioUK);
	}

}
