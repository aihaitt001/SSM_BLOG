package springmvc.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.UsersMapper;
import springmvc.model.User;
import springmvc.util.MD5Util;

@Service
public class UserServiceImpt implements UserService {
	@Autowired
	UsersMapper usersmapper;

	public void add(User user) {
		// TODO Auto-generated method stub

		Date date = new Date();
		Timestamp createtime = new Timestamp(date.getTime());
		user.setCreatetime(createtime);
		user.setLastchange(createtime);
		MD5Util.EncryptUser(user);
		usersmapper.add(user);

	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return usersmapper.list();
	}

	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return usersmapper.getById(id);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		usersmapper.delete(id);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Timestamp lastchange = new Timestamp(date.getTime());
		user.setLastchange(lastchange);
		MD5Util.EncryptUser(user);
		usersmapper.update(user);
	}

	public User checkUsername(String username) {
		// TODO Auto-generated method stub
		return usersmapper.checkUsername(username);
	}

	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		return usersmapper.checkEmail(email);

	}

	public User checkLogin(String username) {
		// TODO Auto-generated method stub
		return usersmapper.checkLogin(username);
	}

}
