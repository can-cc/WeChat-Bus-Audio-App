package daoTest;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tyan.ba.dao.AudioDao;
import com.tyan.ba.dao.CategoryDao;
import com.tyan.ba.entity.category.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class CategoryDaoTest {
	
	@Resource
    private CategoryDao categoryDao;
	
	//@Test
	public void saveTest() {
	    	Category category = new Category("bbs45","very fear");
	    	categoryDao.save(category);
	}
	
	//@Test
	public void updateTest(){
		Category category = new Category();
    	category.setName("superHappyEnglsish");
    	category.setCategoryId(1);
    	category.setDirPath("/happy");
    	category.setDescription("操蛋");
    	category.setCreateDate(new Date());
    	category.setModifiedDate(new Date());
    	categoryDao.update(category);
	}
	
	@Test
	public void findPathTest(){
		
		String dirPath = categoryDao.findPathById(6);
		System.out.println(dirPath);
	}
}
