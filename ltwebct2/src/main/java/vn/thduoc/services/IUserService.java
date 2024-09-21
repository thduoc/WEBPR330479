package vn.thduoc.services;

import vn.thduoc.models.UserModel;

public interface IUserService {

	UserModel findByUsername(String username);
	
	UserModel login(String username, String password);
	
	void insertUser(UserModel user);
	
	boolean register(String username, String password, String email, String fullname, String phone);

	boolean checkExistEmail(String email);
	
	boolean checkExistUsername(String username);
	
	boolean checkExistPhone(String phone);
	
	void updatePassword(String username, String newPassword);
	
}
