package com.tyan.ba.entity.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.tyan.ba.dao.CategoryDao;

public class CategoryServiceAlpha implements CategoryService {
	
	
	@Autowired
	private CategoryDao categoryDao;

	
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public String findAllCategoryList() {
		String categoryText = "以下是英语专辑:\n";
		List<Category> categorys = categoryDao.findAllCategory();
		for(Category category : categorys){
			categoryText += category.getName();
			categoryText += "\n";
		}
		categoryText = categoryText.substring(0, categoryText.length()-1);
		return categoryText;
	}

	@Override
	public int findIdByName(String name) {
		return categoryDao.findIdByName(name);
	}

	@Override
	public String findAllCategoryAndDesList() {
		String categoryText = "以下是英语专辑:\n";
		List<Category> categorys = categoryDao.findAllCategory();
		for(Category category : categorys){
			categoryText += category.getName();
			categoryText += " : ";
			categoryText += category.getDescription();
			categoryText += "\n";
		}
		categoryText = categoryText.substring(0, categoryText.length()-1);
		return categoryText;
	}

	@Override
	public Category findOne(int categoryId) {
		return categoryDao.fineOne(categoryId);
	}

}
