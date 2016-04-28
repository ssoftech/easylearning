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
import edu.easylearning.util.DBUtil;

public class CategoryDao {

	public int save(Category entity) {
		int i = 0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println("date " + dt.format(date));
			Connection con = DBUtil.connect();
			
			String sql = "insert into category(name,creation_date,created_by) values(?,?,?)";
			System.out.println("a");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date));
			ps.setString(3, entity.getCreatedby());
			System.out.println("C");

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int update(Category entity)throws Exception {
		
		int i =0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			
			Connection con = DBUtil.connect();
			String sql = "update category set name=?, modified_date=?, modified_by=? where id=?";
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

	public int delete(Category entity) {

		int i = 0;

		try {
			Connection con = DBUtil.connect();
			String sql = "delete from category where id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, entity.getId());

			i = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;

	}

	public Category findOne(int id) {
		Category entity = new Category();

		return entity;
	}

	public ArrayList<Category> findAll() {
		ArrayList<Category> entityList = new ArrayList<Category>();
		Category entity = null;

		try {
			Connection con = DBUtil.connect();
			String sql = "select * from category";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");

				entity = new Category();
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

	public boolean categoryExist(String category) {
		boolean status = false;
		try {
			Connection con = DBUtil.connect();
			String sql = "select name from category where name=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, category);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
