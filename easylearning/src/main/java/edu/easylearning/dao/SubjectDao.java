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
import edu.easylearning.model.Subject;
import edu.easylearning.util.DBUtil;

public class SubjectDao {

	public int save(Subject entity) {
		int i = 0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();

			Connection con = DBUtil.connect();

			String sql = "insert into subject(name,creation_date,category_id,created_by) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date));
			ps.setInt(3, entity.getCategoryid());
			ps.setString(4, entity.getCreatedby());

			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	public int update(Subject entity) {
		int i = 0;

		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			Connection con = DBUtil.connect();
			String sql1 = "update subject set name=?, modified_date=?, modified_by=? where id=?";
			PreparedStatement ps = con.prepareStatement(sql1);
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

	public int delete(Subject entity) {
		int i = 0;

		try {
			Connection con = DBUtil.connect();
			String sql1 = "delete from subject where id=?";
			PreparedStatement ps = con.prepareStatement(sql1);

			ps.setInt(1, entity.getId());

			i = ps.executeUpdate();

		} catch (SQLException e) {
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
				int id = rs.getInt(1);

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

	
	public ArrayList<Subject> findAll() {
		ArrayList<Subject> entityList = new ArrayList<Subject>();
		Subject entity = null;

		try {
			Connection con = DBUtil.connect();
			String sql = "select s.id,s.name,c.name from subject s inner join category c on s.category_id=c.id";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String category_name = rs.getString(3);
				System.out.println(id + "  " + name + " " + category_name);

				entity = new Subject();
				entity.setId(id);
				entity.setName(name);
				entity.setCategory_name(category_name);

				entityList.add(entity);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entityList;
	}

}
