package edu.easylearning.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DBListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/", "root", "root");

			String sql = "create database IF NOT EXISTS education";

			PreparedStatement ps = con.prepareStatement(sql);
			int i = ps.executeUpdate();

			if (i == 1)
				System.out.println("database created " + i);

			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/education", "root", "root");

			String sql1 = "CREATE TABLE IF NOT EXISTS category(id int AUTO_INCREMENT, name VARCHAR(100) NOT NULL,"
					+ "created_by VARCHAR(100),"
					+ "modified_by VARCHAR(100),creation_date VARCHAR(100),modified_date VARCHAR(100), primary key(id),UNIQUE (name))";

			PreparedStatement ps1 = con1.prepareStatement(sql1);
			int i1 = ps1.executeUpdate();
			System.out.println("category TABLE created " + i1);

			String sql2 = "CREATE TABLE if not exists subcategory(id int auto_increment,"
					+ "name varchar(100) not null,created_by VARCHAR(100),creation_date VARCHAR(100),modified_by VARCHAR(100),modified_date VARCHAR(100),category_id int, primary key(id),foreign key(category_id) references category(id) ON DELETE CASCADE)";

			PreparedStatement ps2 = con1.prepareStatement(sql2);
			int i2 = ps2.executeUpdate();

			System.out.println("subcategory TABLE created " + i2);

			String sql3 = "CREATE TABLE if not exists subject(id int auto_increment,"
					+ "name varchar(100) not null,created_by VARCHAR(100),creation_date VARCHAR(100),modified_by VARCHAR(100),modified_date VARCHAR(100),category_id int, primary key(id),foreign key(category_id) references category(id) ON DELETE CASCADE)";

			PreparedStatement ps3 = con1.prepareStatement(sql3);
			int i3 = ps3.executeUpdate();

			System.out.println("subject TABLE created " + i3);

			String sql4 = "CREATE TABLE IF NOT EXISTS standard(id int AUTO_INCREMENT, name VARCHAR(100) NOT NULL,"
					+ "created_by VARCHAR(100),"
					+ "modified_by VARCHAR(100),creation_date VARCHAR(100),modified_date VARCHAR(100),UNIQUE(name), primary key(id))";

			PreparedStatement ps4 = con1.prepareStatement(sql4);
			int i4 = ps4.executeUpdate();

			System.out.println("subcategory TABLE created " + i4);

			String sql5 = "CREATE TABLE if not exists chapter(id int AUTO_INCREMENT,name varchar(200),created_by VARCHAR(100),modified_by VARCHAR(100),"
					+ "creation_date VARCHAR(100),modified_date VARCHAR(100),subject_id int,standard_id int, primary key(id),foreign key(standard_id) references standard(id),foreign key(subject_id) references subject(id) ON DELETE CASCADE)";

			PreparedStatement ps5 = con1.prepareStatement(sql5);
			int i5 = ps5.executeUpdate();

			System.out.println("subcategory TABLE created " + i5);

			String sql6 = "CREATE TABLE IF NOT EXISTS type(id int AUTO_INCREMENT, name VARCHAR(100) NOT NULL,"
					+ "created_by VARCHAR(100),"
					+ "modified_by VARCHAR(100),creation_date VARCHAR(100),modified_date VARCHAR(100), UNIQUE(name),primary key(id),UNIQUE(name))";

			PreparedStatement ps6 = con1.prepareStatement(sql6);
			int i6 = ps6.executeUpdate();

			System.out.println("type TABLE created " + i6);

			String sql7 = "CREATE TABLE if not exists content(id int AUTO_INCREMENT,WYSIWYG_Editor varchar(200),Image varchar(200),File_Video varchar(200),created_by VARCHAR(100),modified_by VARCHAR(100),"
					+ "creation_date VARCHAR(100),modified_date VARCHAR(100),category_id int,subcategory_id int,standard_id int,type_id int,subject_id int,chapter_id int, primary key(id),"
					+ "foreign key(category_id) references category(id),foreign key(subcategory_id) references subcategory(id),foreign key(standard_id) references standard(id),foreign key(type_id) references type(id),"
					+ "foreign key(subject_id) references subject(id),foreign key(chapter_id) references chapter(id) ON DELETE CASCADE)";

			PreparedStatement ps7 = con1.prepareStatement(sql7);
			int i7 = ps7.executeUpdate();

			System.out.println("content TABLE created " + i7);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
