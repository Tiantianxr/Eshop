package com.zy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Driver;
import com.zy.bean.Good;
import com.zy.bean.User;

public class UserDao {

	public int addUser(User user) {
		int result=0;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="insert into user values (?,?,?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setObject(1, 0);
			ps.setObject(2, user.getUsername());
			ps.setObject(3, user.getPassword());
			ps.setObject(4, user.getMobile());
			
			result=ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public User queryUser(String username,String password) {
		User user=null;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="select * from user where username=? and password=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setObject(1, username);
			ps.setObject(2, password);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String mobile = rs.getString("mobile");
				user=new User(id, username, password, mobile);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
