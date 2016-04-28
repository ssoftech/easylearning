package edu.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import edu.easylearning.model.Subject;
import edu.easylearning.util.DBUtil;

public class SubjectDao {

	public int save(Subject entity) {
		int i = 0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			
			Connection con = DBUtil.connect();
			
			String sql = "insert into subject(name,creation_date,created_by) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date));
			ps.setString(3, entity.getCreatedby());
			

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int update(Subject entity) {
		int i =0;
		
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			Connection con = DBUtil.connect();
			String sql1="update subject set name=?, modified_date=?, modified_by=? where id=?";
			PreparedStatement ps=con.prepareStatement(sql1);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date1));
			ps.setString(3, entity.getModifiedby());
			ps.setInt(4, entity.getId());
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return i;
	}

	public int delete(Subject entity) {
		int i=0;
		
		try{
			Connection con = DBUtil.connect();
			String sql1="delete from subject where id=?";
			PreparedStatement ps=con.prepareStatement(sql1);
			
			ps.setInt(1,entity.getId());
			
		
			i=  ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public Subject findOne(int id) {
		
		

		Subject entity = new Subject();
		return entity;
	}

	public ArrayList<Subject> findAll() {
		ArrayList<Subject> entityList = new ArrayList<Subject>();
		Subject entity = null;
		try {
			Connection con = DBUtil.connect();
			String sql = "select * from subject";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id"); 
				String name = rs.getString("name");
				
				
				  entity=new Subject();
				  entity.setId(id);
				  entity.setName(name);
				  
				
				entityList.add(entity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entityList;
	}
	
	


	
}



