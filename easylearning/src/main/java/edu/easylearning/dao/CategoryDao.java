package edu.easylearning.dao;

import java.util.ArrayList;

import edu.easylearning.model.Category;

public class CategoryDao {
	
	public int save(Category entity)
	{
		return 1;
	}
	
	public int update(Category entity)
	{
		return 1;
	}
	
	public int delete(Category entity)
	{
		return 1;
	}
	
	public Category findOne(int id)
	{
		Category entity = new Category();
		
		return entity;
	}
	
	public ArrayList<Category> findAll()
	{
		ArrayList<Category> entityList = new ArrayList<Category>();
		return entityList;
	}

}
