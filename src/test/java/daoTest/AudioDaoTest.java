package daoTest;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tyan.ba.dao.AudioDao;
import com.tyan.ba.entity.audio.Audio;
import com.tyan.ba.vo.AudioUK;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class AudioDaoTest {

	@Resource
    private AudioDao audioDao;
	
	@Test
	public void saveTest() {
	    try {  
	    	Audio audio = new Audio();
			audio.setName("oop5");
			audio.setCategoryId(2);
			audio.setFilename("oop.mp3");
			
			audioDao.save(audio);
	    } catch (DataAccessException e) {  
	    	System.out.println(e.getCause());
	    	System.out.println(e.getMessage());
	    	System.out.println(e.getLocalizedMessage());
	    	
	        SQLException sqle = (SQLException) e.getCause();  
	       // System.out.println("Error code: " + sqle.getErrorCode());  
	       // System.out.println("SQL state: " + sqle.getSQLState());  
	    }  
	}
	
	//@Test
	public void deleteTest() {
	    try {  
	    	Audio audio = new Audio();
			audio.setName("happy");
			audio.setCategoryId(1);
			audio.setFilename("happy.mp3");
			
			audioDao.delete(audio);
	    } catch (DataAccessException e) {  
	    	System.out.println(e.getCause());
	    }  
	}
	
	//@Test
	public void updateTest(){
		Audio audio = new Audio();
		audio.setName("happy");
		audio.setCategoryId(1);
		audio.setFilename("happy333.mp3");
		audio.setCreateDate(new Date());
		audioDao.update(audio);
	}
	
	//@Test 
	public void findOneTest(){
		AudioUK auk = new AudioUK("happy", 1);
		Audio audio = audioDao.findOne(auk);
		System.out.println(audio.getName());
		System.out.println(audio.getCategoryId());
		System.out.println(audio.getFilename());
		System.out.println(audio.getPlaytime());
		System.out.println(audio.getBitrate());
		System.out.println(audio.getCreateDate());
		System.out.println(audio.getModifiedDate());
		System.out.println(audio.getDescription());
		System.out.println(audio.getAuthority());
		
	}

}
