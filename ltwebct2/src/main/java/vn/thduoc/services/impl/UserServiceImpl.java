package vn.thduoc.services.impl;
import java.sql.Date;

import vn.thduoc.dao.IUserDao;
import vn.thduoc.dao.impl.UserDaoImpl;
import vn.thduoc.models.UserModel;
import vn.thduoc.services.IUserService;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = new UserDaoImpl();

	@Override
	public UserModel findByUsername(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.findByUsername(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public void insertUser(UserModel user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean register(String username, String password, String email, String fullname, String phone) {
		if (userDao.checkExistUsername(username) || userDao.checkExistEmail(email) || userDao.checkExistPhone(phone)) {
			return false;
		} else {
			long millis = System.currentTimeMillis();
			Date date = new Date(millis);
			userDao.insertUser(new UserModel(username, password, email, fullname, null, phone, 3, date));
			return true;
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean checkExistPhone(String phone) {
		return userDao.checkExistPhone(phone);
	}

	@Override
	public void updatePassword(String username, String newPassword) {
		userDao.updatePassword(username, newPassword);
	}

	// Test chương trình. Kích phải chuột chọn run as->java application
	public static void main(String[] args) {
		try {
			IUserService user = new UserServiceImpl();
			user.updatePassword("tnat", "123456");
			System.out.println(user.findByUsername("tnat"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
