package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.UsersMapper;
import springmvc.model.User;

@Service
public class UserServiceImpt implements UserService {
	@Autowired
	UsersMapper usersmapper;

	public void add(User user) {
		// TODO Auto-generated method stub
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

}
