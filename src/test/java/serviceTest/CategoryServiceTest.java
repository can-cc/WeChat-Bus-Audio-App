package serviceTest;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.tyan.ba.entity.category.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/application-config.xml")  
public class CategoryServiceTest {
	@Resource
    private CategoryService categoryService;
	
	@Test
	public void testFindId(){
		System.out.println(categoryService.findIdByName("bbs12"));
	}
	

}
