package edu.easylearning.service;


import java.util.ArrayList;


import edu.easylearning.dao.SubcategoryDao;
import edu.easylearning.model.Category;
import edu.easylearning.model.Subcategory;

public class SubcategoryService {
	
	public int save(Subcategory entity)
	{
		SubcategoryDao dao = new SubcategoryDao();
		return dao.save(entity);
	}

	public ArrayList<Category> findone() {
		SubcategoryDao dao = new SubcategoryDao();
		return dao.find();
	}

	
	public ArrayList<Subcategory> findAll() {
		SubcategoryDao dao = new SubcategoryDao();
		return dao.findAll();
	}
	
	public int update(Subcategory entity) {
		SubcategoryDao dao = new SubcategoryDao();
		return dao.update(entity);
	}
	
	public int delete(Subcategory entity) {
		SubcategoryDao dao = new SubcategoryDao();
		return dao.delete(entity);
	}
	
}
