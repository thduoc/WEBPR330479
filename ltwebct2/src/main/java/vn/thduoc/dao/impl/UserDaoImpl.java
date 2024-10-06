package vn.thduoc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.thduoc.configs.DBConnectSQL;
import vn.thduoc.dao.IUserDao;
import vn.thduoc.models.UserModel;

public class UserDaoImpl implements IUserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public UserModel findByUsername(String username) {
		String sql = "SELECT * FROM ltwebct2.dbo.users WHERE username = ? ";
		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);	//truyền tham số
			rs = ps.executeQuery();		//thực thi phát biểu prepare rồi đưa kq vào result
			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreatedate(rs.getDate("createdate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertUser(UserModel user) {
String query = "INSERT INTO `ltweb`.`users` (username, password, email, fullname, images, phone, roleid, createdate) VALUES (?,?,?,?,?,?,?,?)";
		
		try {
			// mở kết nối
			new DBConnectSQL();
			conn = DBConnectSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getFullname());
			ps.setString(5, user.getImages());
			ps.setString(6, user.getPhone());
			ps.setInt(7, user.getRoleid());
			ps.setDate(8, user.getCreatedate());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistUsername(String username) {
		boolean duplicate = false;
		String query = "SELECT * FROM ltweb.users WHERE username = ? ";
		try {
			// mở kết nối
			new DBConnectSQL();
			conn = DBConnectSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {

		}
		return duplicate;
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "SELECT * FROM ltweb.users WHERE email = ? ";
		try {
			// mở kết nối
			new DBConnectSQL();
			conn = DBConnectSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {

		}
		return duplicate;
	}

	@Override
	public boolean checkExistPhone(String phone) {
		boolean duplicate = false;
		String query = "SELECT * FROM ltweb.users WHERE phone = ? ";
		try {
			// mở kết nối
			new DBConnectSQL();
			conn = DBConnectSQL.getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, phone);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception e) {

		}
		return duplicate;
	}

	@Override
	public void updatePassword(String username, String newPassword) {
		//UPDATE `ltweb`.`users` SET `password` = 'Abc123.' WHERE (`id` = '9');
				String query = "UPDATE `ltweb`.`users` SET password = ? WHERE (username = ?);";
				try {
					new DBConnectSQL();
					conn = DBConnectSQL.getConnection();
					ps = conn.prepareStatement(query);
					ps.setString(1, newPassword);
					ps.setString(2, username);
					ps.executeUpdate();
				} catch (Exception e) {
					
				}
	}
//	 // Test chương trình. Kích phải chuột chọn run as->java application
//		public static void main(String[] args) {
//			try {
//				IUserDao userDao = new UserDaoImpl();
//				System.out.println(userDao.findByUsername("duocnt"));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
}
