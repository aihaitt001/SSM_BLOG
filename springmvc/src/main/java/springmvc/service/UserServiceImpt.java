package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.UsersMapper;
import springmvc.model.User;

@Service
public class UserServiceImpt implements UserService{
	@Autowired
	UsersMapper usersmapper ;
	public void Add(User user) {
		// TODO Auto-generated method stub
		usersmapper.add(user);
		
	}

	public List<User> list() {
		// TODO Auto-generated method stub
		return usersmapper.list();
	}

	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return usersmapper.getByUsername(username);
	}

	public void Delete(String username) {
		// TODO Auto-generated method stub
		usersmapper.delete(username);
	}

	public void Update(int id, String username) {
		// TODO Auto-generated method stub
		usersmapper.update(id, username);
	}
	
	
}
