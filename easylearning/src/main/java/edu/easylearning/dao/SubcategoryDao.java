package edu.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.easylearning.model.Category;
import edu.easylearning.model.Subcategory;
import edu.easylearning.util.DBUtil;


public class SubcategoryDao {
	
	public int save(Subcategory entity) {
		int i = 0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println("date " + dt.format(date));
			Connection con = DBUtil.connect();
			
			String sql = "insert into subcategory(name,creation_date,category_id,created_by) values(?,?,?,?)";
			System.out.println("a");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date));
			ps.setInt(3, entity.getCategoryid());
			ps.setString(4, entity.getCreatedby());
			System.out.println("C");

			i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}
	
	
	
	public ArrayList<Category> find() {
		ArrayList<Category> entityList = new ArrayList<Category>();
		Category entity = null;

		try {
			Connection con = DBUtil.connect();
			String sql = "select id,name from category";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			   String name = rs.getString("name");
			   int id=rs.getInt(1);

				entity = new Category();
				
				entity.setName(name);
				entity.setId(id);

				entityList.add(entity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entityList;
	}
	
	public ArrayList<Subcategory> findAll() {
		ArrayList<Subcategory> entityList = new ArrayList<Subcategory>();
		Subcategory entity = null;

		try {
			Connection con = DBUtil.connect();
			String sql = "select * from Subcategory";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				entity = new Subcategory();
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
	
	
public int update(Subcategory entity) {
		
		int i =0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			
			Connection con = DBUtil.connect();
			String sql = "update subcategory set name=?, modified_date=?, modified_by=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date1));
			ps.setString(3, entity.getModifiedby());
			ps.setInt(4, entity.getId());
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return i;
	}


     public int delete(Subcategory entity) {

	  int i = 0;

	 try {
		Connection con = DBUtil.connect();
		String sql = "delete from subcategory where id=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, entity.getId());

		i = ps.executeUpdate();

	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	 return i;

}
	
}	
