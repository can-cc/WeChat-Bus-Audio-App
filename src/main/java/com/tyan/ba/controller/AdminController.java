package com.tyan.ba.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tyan.ba.dao.AudioDao;
import com.tyan.ba.dao.CategoryDao;
import com.tyan.ba.entity.audio.AudioService;
import com.tyan.ba.entity.category.Category;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private AudioService audioService;

	@RequestMapping(method = RequestMethod.GET)
	String home(Model model){
		model.addAttribute("message", "hello,world!");
		return "admin/adminHome";
	}
	//删除音频
	//删除专辑and里面的音频
	//清空所有专辑
	//清空专辑内音频
	
	//显示专辑列表
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	String category(Model model){
		
		//warning 混乱
		model.addAttribute("categoryList", ((CategoryDao) appContext.getBean("categoryDao")).findAllCategory());
		return "/admin/category";
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!rest!!!!!!!!!!!!!!!!11
	//显示某一专辑（查询）
	@RequestMapping(value = "/showCategory", method = RequestMethod.GET)
	String showCategory(@RequestParam int categoryId, @RequestParam String categoryName,Model model){
		model.addAttribute("audioList", ((AudioDao) appContext.getBean("audioDao")).
				findAudioByCategory(categoryId));    //warning：dao层和service层混乱
		model.addAttribute("categoryName", categoryName);
		model.addAttribute("categoryId", categoryId);
		return "/admin/showCategory";
	}
	//新增音频页面
	//required=false 为空不会抛错
	@RequestMapping(value = "/addAudio", method = RequestMethod.GET)
	String addAudioView(@RequestParam(value="categoryId", required=false) String categoryId, Model model){
		model.addAttribute("categoryList", ((CategoryDao) appContext.getBean("categoryDao")).findAllCategory());
		
		if(categoryId != null){
			String jqScript = "<script type=\"text/javascript\">"
					+ "jQuery(function(){"
					+ "$(\"#selector\").find(\"option[value='" + categoryId + "']\").attr(\"selected\",true);"
					+ "});" + "</script>";
			model.addAttribute("script", jqScript);
		}
		return "/admin/addAudio";
	}
	
	//新增音频处理
	//warning 判空！
	@RequestMapping(value = "/addAudio", method = RequestMethod.POST)
	String addAudio(@RequestParam("name") String audioName, 
					@RequestParam("categoryId") int categoryId, 
					@RequestParam("audioFile") MultipartFile audioFile, 
					@RequestParam("description") String description, 
					Model model){
		boolean result = audioService.saveAudio(audioName, categoryId, description, audioFile);
		if(result){
			model.addAttribute("message", "成功！");
			model.addAttribute("timeUrl", "1;url=/admin");
			return "/util/timingError";
		} else {
			model.addAttribute("message", "失败!");
			return "error/Error";
		}
	}
	
	//新增专辑页面
	@RequestMapping(value = "/addCategory", method = RequestMethod.GET)
	String addCategoryView(Model model){
		return "/admin/addCategory";
	}
	//新增专辑处理
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	String addCategory(@RequestParam String name, @RequestParam String description, Model model){
		System.out.println(name);
		System.out.println(description);
		Category category = new Category(name, description);
	    try {  
	    	((CategoryDao) appContext.getBean("categoryDao")).save(category);
	    	model.addAttribute("message", "创建成功！");
	    } catch (DataAccessException e) {  
	    	System.out.println(e.getCause());
	    	model.addAttribute("message", "创建失败");
	    }  
	    model.addAttribute("timeUrl","1;url=/admin/addCategory");
		return "/util/timingJump";
	}
	
	
}
