package edu.easylearning.service;

import java.util.ArrayList;


import edu.easylearning.dao.StandardDao;
import edu.easylearning.model.Standard;

public class StandardServices {
	
	public int save(Standard entity)
	{
		StandardDao dao = new StandardDao();
		return dao.save(entity);
	}
	
	public int update(Standard entity)
	{
		StandardDao dao = new StandardDao();
		return dao.update(entity);
	}
	
	public int delete(Standard entity)
	{
		StandardDao dao = new StandardDao();
		return dao.delete(entity);
	}
	
	public Standard findOne(int id)
	{
		StandardDao dao = new StandardDao();
		return dao.findOne(id);
	}
	
	public ArrayList<Standard> findAll()
	{
		StandardDao dao = new StandardDao();
		return dao.findAll();
	}

}
