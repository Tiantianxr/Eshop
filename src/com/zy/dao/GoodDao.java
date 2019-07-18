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

public class GoodDao {
	
	public int addCart(String good_id,int good_number) {
		int result=0;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="insert into good_cart values (?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setObject(1, good_id);
			ps.setObject(2, good_number);
			
			result=ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	public int updateCart(String good_id,int good_number) {
		int result=0;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="update good_cart set number=? where good_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setObject(1, good_number);
			ps.setObject(2, good_id);
			
			result = ps.executeUpdate();
			
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return result;
	}
	
	public List<Good> queryCartGoods(){
		ArrayList<Good> goods = new ArrayList<>();
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="select g.*,gc.number from good g,good_cart gc where g.id=gc.good_id";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String image = rs.getString("image");
				String message = rs.getString("message");
				double price = rs.getDouble("price");
				String shopName = rs.getString("shop_name");
				int number = rs.getInt("number");
				
				Good good = new Good(id, image, message, price, shopName, number, price*number);
				goods.add(good);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return goods;
	}
	
	public Good queryCartGood(String id){
		Good good=null;
		try {
			DriverManager.registerDriver(new Driver());
			Connection conn=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/e_shop?characterEncoding=UTF-8",
					"root","123456");
			String sql="select * from good_cart where good_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int number = rs.getInt("number");
				good = new Good(id,number);
			}
			
			rs.close();
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return good;
	}
}
