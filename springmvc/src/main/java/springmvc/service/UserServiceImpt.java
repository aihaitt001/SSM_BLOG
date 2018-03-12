package springmvc.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.UsersMapper;
import springmvc.model.User;
import springmvc.util.MD5Util;
import springmvc.util.TimeUtil;

@Service
public class UserServiceImpt implements UserService {
	@Autowired
	UsersMapper usersmapper;

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub

		// Date date = new Date();
		Timestamp createtime = TimeUtil.now();
		user.setCreatetime(createtime);
		user.setLastchange(createtime);
		// md5编码，并添加随机盐
		MD5Util.EncryptUser(user);
		usersmapper.add(user);

	}

	@Override
	public void flushUsers() {
		usersmapper.flushUsers();
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return usersmapper.list();
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		return usersmapper.getById(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		usersmapper.delete(id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Date date = new Date();
		Timestamp lastchange = new Timestamp(date.getTime());
		user.setLastchange(lastchange);
		MD5Util.EncryptUser(user);
		usersmapper.update(user);
	}

	@Override
	public User checkUsername(String username) {
		// TODO Auto-generated method stub
		return usersmapper.checkUsername(username);
	}

	@Override
	public String checkEmail(String email) {
		// TODO Auto-generated method stub
		return usersmapper.checkEmail(email);

	}

	@Override
	public User checkLogin(String username) {
		// TODO Auto-generated method stub
		return usersmapper.checkLogin(username);
	}

}
