package springmvc.service;

import java.util.List;

import springmvc.model.User;

public interface UserService {
	String checkUsername(String username);
	List<User> list();
	void add(User user);	
	User getById(Integer id);
	void delete(Integer id);
	void update(User user);
	
}
