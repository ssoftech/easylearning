package edu.easylearning.service;

import java.util.ArrayList;

import edu.easylearning.dao.SubcategoryDao;
import edu.easylearning.dao.SubjectDao;
import edu.easylearning.model.Category;
import edu.easylearning.model.Subject;

public class SubjectService {
	
	public int save(Subject entity)
	{
		SubjectDao dao = new SubjectDao();
		
		return dao.save(entity);
		
	}
	
	public int update(Subject entity)
	{
		SubjectDao dao = new SubjectDao();
		
		return dao.update(entity);
	}
	
	public int delete(Subject entity)
	{
		SubjectDao dao = new SubjectDao();
		return dao.delete(entity);
	}

	public ArrayList<Category> findone() {
		SubcategoryDao dao = new SubcategoryDao();
		return dao.find();
	}
	
	
	
	
	public ArrayList<Subject> findAll()
	{
		SubjectDao dao = new SubjectDao();
		return dao.findAll();
	}
	
	
}
