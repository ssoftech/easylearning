package edu.easylearning.service;

import java.util.ArrayList;

import edu.easylearning.dao.ChapterDao;
import edu.easylearning.model.Chapter;
import edu.easylearning.model.Standard;
import edu.easylearning.model.Subject;

public class ChapterService {

	public int save(Chapter entity) {
		ChapterDao dao = new ChapterDao();
		return dao.save(entity);
	}

	public int update(Chapter entity) {
		ChapterDao dao = new ChapterDao();
		return dao.update(entity);
	}

	public int delete(Chapter entity) {
		ChapterDao dao = new ChapterDao();
		return dao.delete(entity);
	}
	
	public ArrayList<Chapter> findAll() {
		ChapterDao dao = new ChapterDao();
		return dao.findAll();
	}
	

	public ArrayList<Standard> findonestandard() {
		ChapterDao dao = new ChapterDao();
		return dao.findonestandard();
	}

	public ArrayList<Subject> findonesubject() {
		ChapterDao dao = new ChapterDao();
		return dao.findonesubject();
	}

}
