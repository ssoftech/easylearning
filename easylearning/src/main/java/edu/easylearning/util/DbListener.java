package edu.easylearning.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent arg0) {

		try {
			Connection con = DBUtil.connect();

			String sql = "create database if not exists education";
			Statement st = con.createStatement();
			st.executeUpdate(sql);
			System.out.println("database created");

			String sql1 = "CREATE TABLE if not exists category(CategoryID int auto_increment,"
					+ "CategoryName varchar(200) not null, primary key(CategoryID))";

			st = con.createStatement();
			st.executeUpdate(sql1);

			String sql2 = "CREATE TABLE if not exists subcategory(SubcategoryID int auto_increment,"
					+ "SubcategoryName varchar(200) not null,CategoryID int(20), primary key(subcategoryID))";
			st = con.createStatement();
			st.executeUpdate(sql2);

			String sql3 = "CREATE TABLE if not exists type(TypeID int auto_increment,"
					+ "TypeName varchar(200) not null,SubcategoryID int(20), primary key(TypeID))";
			st = con.createStatement();
			st.executeUpdate(sql3);

			String sql4 = "CREATE TABLE if not exists subject(SubjectID int auto_increment,"
					+ "SubjectName varchar(200) not null, primary key(SubjectID))";
			st = con.createStatement();
			st.executeUpdate(sql4);

			String sql5 = "CREATE TABLE if not exists chapter(ChapterID int auto_increment,"
					+ "ChapterName varchar(200) not null,SubjectID int(20),SubcategoryID int(20), primary key(ChapterID))";
			st = con.createStatement();
			st.executeUpdate(sql5);
			System.out.println("table created");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
