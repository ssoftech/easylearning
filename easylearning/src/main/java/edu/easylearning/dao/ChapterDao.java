package edu.easylearning.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import edu.easylearning.model.Chapter;
import edu.easylearning.model.Standard;
import edu.easylearning.model.Subject;
import edu.easylearning.util.DBUtil;

public class ChapterDao {
	
	public int save(Chapter entity) {
		int i = 0;
		try {
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date = new Date();
			System.out.println("date " + dt.format(date));
			Connection con = DBUtil.connect();
			
			String sql = "insert into chapter(name,creation_date,standard_id,subject_id,created_by) values(?,?,?,?,?)";
			System.out.println("a");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, entity.getName());
			ps.setString(2, dt.format(date));
			ps.setInt(3, entity.getStandardid());
			ps.setInt(4, entity.getSubjectid());
			ps.setString(5, entity.getCreatedby());
			System.out.println("C");

			i = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}
	
	
public int update(Chapter entity) {
		
		int i =0;
		try {
			
			DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			
			Connection con = DBUtil.connect();
			String sql = "update chapter set name=?, modified_date=?, modified_by=? where id=?";
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

	
public int delete(Chapter entity) {

	  int i = 0;

	 try {
		Connection con = DBUtil.connect();
		String sql = "delete from chapter where id=?";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, entity.getId());

		i = ps.executeUpdate();

	 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
	 return i;

}
    
public ArrayList<Chapter> findAll() {
	ArrayList<Chapter> entityList = new ArrayList<Chapter>();
	Chapter entity = null;
	

	try {
		Connection con = DBUtil.connect();
		//String sql = "select * from chapter";
		String sql = "select c.id,c.name,st.name,su.name from chapter c inner join standard st on c.standard_id=st.id inner join subject su on c.subject_id=su.id";
		//String sql = "select c.id,c.name,st.name,from chapter c inner join standard st on c.standard_id=st.id";
		//String sql = "select s.id,s.name,c.name from subcategory s inner join category c on s.category_id=c.id";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int id = rs.getInt(1);
			String name = rs.getString(2);
			String Standard_name = rs.getString(3);
			String Subject_name  = rs.getString(4);
			System.out.println("Standard...."+Standard_name);
			System.out.println("Subject...."+Subject_name);
			
			entity = new Chapter();
			entity.setId(id);
			entity.setName(name);
			entity.setStandard_name(Standard_name);	
			entity.setSubject_name(Subject_name);
			
			entityList.add(entity);
			

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return entityList;
	
	
	
}

public ArrayList<Standard> findonestandard() {
	ArrayList<Standard> entityList = new ArrayList<Standard>();
	Standard entity = null;

	try {
		Connection con = DBUtil.connect();
		String sql = "select id,name from standard";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		   String name = rs.getString("name");
		   int id=rs.getInt(1);

			entity = new Standard();
			
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


public ArrayList<Subject> findonesubject() {
	ArrayList<Subject> entityList = new ArrayList<Subject>();
	Subject entity = null;

	try {
		Connection con = DBUtil.connect();
		String sql = "select DISTINCT name from subject";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
		   String name = rs.getString("name");
		   //int id=rs.getInt(1);

			entity = new Subject();
			
			entity.setName(name);
			//entity.setId(id);

			entityList.add(entity);

		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	return entityList;
} 
}
