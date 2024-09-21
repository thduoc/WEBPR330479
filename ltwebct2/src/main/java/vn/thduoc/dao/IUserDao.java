package vn.thduoc.dao;

import vn.thduoc.models.UserModel;

public interface IUserDao {
	
	UserModel findByUsername(String username);
	
	void insertUser(UserModel user);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistEmail(String email);
	
	boolean checkExistPhone(String phone);
	
	void updatePassword(String username, String newPassword);
}
