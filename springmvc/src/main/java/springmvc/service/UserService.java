package springmvc.service;

import java.util.List;

import springmvc.model.User;

public interface UserService {
	List<User> list();
	void Add(User user);	
	User getByUsername(String username);
	void Delete(String username);
	void Update(int id,String username);
	
}
