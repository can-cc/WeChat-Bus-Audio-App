package com.tyan.ba.dao;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import com.tyan.ba.entity.category.Category;

public class CategoryDao {
	//以后增加禁止词  专辑 听力专辑等
	
	private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertCategory;
    
   // private final String baseDirPath = BAConstant.baseStoragePath + "/category";
    
    public boolean createDir(Category category) {
    	File dir = new File(category.getDirPath());
    	return dir.mkdir();
    }
    
    public CategoryDao(BasicDataSource dataSource) {
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.insertCategory = new SimpleJdbcInsert(dataSource).withTableName("category").usingGeneratedKeyColumns("categoryId");
	}
	
    //以后设置抛出
	public void save(Category category) {
		SqlParameterSource parameters = new BeanPropertySqlParameterSource(category);
		Number newId = insertCategory.executeAndReturnKey(parameters);
		category.setCategoryId(newId.intValue());
		createDir(category);
	}

	public int findIdByName(String name) {
		if(name == null)
			return -1;
		try {
			int id = this.jdbcTemplate.queryForObject(
					"select categoryId from category where name = ?",
					Integer.class, name);
			return id;
		}catch (EmptyResultDataAccessException e) {
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		} 
	}
	
	public String findPathById(int categoryId){
		return this.jdbcTemplate.queryForObject(
				"select dirPath from category where categoryId = ?", String.class, categoryId);
	}
	
	public void update(Category category){
		int categoryId = category.getCategoryId();
		String name = category.getName();
		String dirPath = category.getDirPath();
		String coverPath = category.getCoverPath();
		String description = category.getDescription();
		Date createDate = category.getCreateDate();
		Date modifiedDate = category.getModifiedDate();
		int authority = category.getAuthority();
		this.jdbcTemplate.update(
		        "update category set "
		        + "name = ?,"
		        + "categoryId = ?,"
		        + "dirPath = ?,"
		        + "coverPath = ?,"
		        + "modifiedDate = ?,"
		        + "createDate = ?,"
		        + "description = ?,"
		        + "authority = ?  where categoryId = ?",
		        name, categoryId, dirPath, coverPath, modifiedDate, createDate, description, authority,
		        categoryId);
	}
	
	public List<Category> findAllCategory(){
		return this.jdbcTemplate.query( "select "
				+ "name,"
				+ "categoryId ,"
		        + "dirPath,"
		        + "coverPath,"
		        + "modifiedDate,"
		        + "createDate,"
		        + "description,"
		        + "authority " 
				+ "from category", new CategoryMapper());
	}
	
	public void deleteAll(){
		
	}
	
	public void deleteById(int categoryId){
		
	}
	
	private static final class CategoryMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet arg0, int arg1) throws SQLException {
			Category category = new Category();
			category.setName(arg0.getString("name"));
			category.setCategoryId(arg0.getInt("categoryId"));
			category.setDirPath(arg0.getString("dirPath"));
			category.setCoverPath(arg0.getString("coverPath"));
			category.setCreateDate(arg0.getDate("createDate"));
			category.setModifiedDate(arg0.getDate("modifiedDate"));
			category.setDescription(arg0.getString("description"));
			category.setAuthority(arg0.getInt("authority"));
			return category;
		}
	}

	public Category fineOne(int categoryId) {
		return this.jdbcTemplate.queryForObject("select "
				+ "name,"
				+ "categoryId ,"
		        + "dirPath,"
		        + "coverPath,"
		        + "modifiedDate,"
		        + "createDate,"
		        + "description,"
		        + "authority " 
				+ "from category where categoryId = ?", 
				new Object[]{categoryId},
				new CategoryMapper());

	}

}
