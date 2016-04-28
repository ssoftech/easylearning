package edu.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.easylearning.model.Standard;

import edu.easylearning.util.DBUtil;


public class StandardDao {
	
	
	public int save(Standard entity) {
		int i = 0;
		try {
			
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			
			Connection con = DBUtil.connect();
			String sql = "insert into standard(name,created_by,modified_by,modified_date) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getCreatedby());
			ps.setString(3, entity.getCreationdate());
			ps.setString(4, dt.format(date));
			
			

			i = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return i;
	}
	
	public int update(Standard entity) 
	{  
		int i=0;
		try
		{
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			Connection con=DBUtil.connect();
			
			PreparedStatement ps=con.prepareStatement("update standard set name=?,modified_by=?,modified_date=? where id=?");
			ps.setString (1,entity.getName());
			ps.setString(2, entity.getModifiedby());
			ps.setString(3, dt.format(date));
			ps.setInt (4,entity.getId());
			
			i=ps.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return i;
	}

	public int delete(Standard entity) {
      int i=0;
		
		try{
			Connection con = DBUtil.connect();
			String sql1="delete from standard where id=?";
			PreparedStatement ps=con.prepareStatement(sql1);
			
			ps.setInt(1,entity.getId());
			
		
			i=  ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	public Standard findOne(int id) {

		Standard entity = new Standard();
		return entity;
	}
	
	public ArrayList<Standard> findAll()
	{
		ArrayList<Standard> entityList = new ArrayList<Standard>();
		
		System.out.println("connection created");
		
		Standard entity = null;
		
		try
		{
			Connection con = DBUtil.connect();
			String sql = "select * from standard";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id=rs.getInt("id"); 
				String name = rs.getString("name");
				
				
				  entity=new Standard();
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
