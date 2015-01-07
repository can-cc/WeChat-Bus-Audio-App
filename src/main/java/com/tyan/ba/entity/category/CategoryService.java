package com.tyan.ba.entity.category;

public interface CategoryService {
	public String findAllCategoryList();
	public String findAllCategoryAndDesList();
	public int findIdByName(String name);
	public Category findOne(int categoryId);
}
