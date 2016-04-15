package edu.easylearning.service;

import java.util.ArrayList;

import edu.easylearning.dao.CategoryDao;
import edu.easylearning.model.Category;

public class CategoryService {
	
	public int save(Category entity)
	{
		CategoryDao dao = new CategoryDao();
		return dao.save(entity);
	}
	
	public int update(Category entity)
	{
		CategoryDao dao = new CategoryDao();
		return dao.update(entity);
	}
	
	public int delete(Category entity)
	{
		CategoryDao dao = new CategoryDao();
		return dao.delete(entity);
	}
	
	public Category findOne(int id)
	{
		CategoryDao dao = new CategoryDao();
		return dao.findOne(id);
	}
	
	public ArrayList<Category> findAll()
	{
		CategoryDao dao = new CategoryDao();
		return dao.findAll();
	}

}
