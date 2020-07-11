/**
 * @author ：yankesu
 * @description：TODO
 * @date ：2020/7/2 上午11:34
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import entity.Product;
import entity.ProductDB;

public class DBdao {
	public List<ProductDB> readFirstProduct() {
		List<ProductDB> list = new ArrayList<ProductDB>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "root", "123456789");
			String sql = "select * from product";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				ProductDB tl = new ProductDB(id, name, price);
				list.add(tl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public List<Product> readProduct() {
		List<Product> list = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456789");
			String sql = "select * from cart";
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int num=rs.getInt("num");
				Product tl = new Product(id, name, price,num);
				list.add(tl);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}
