package springmvc.service;

import java.util.List;

import springmvc.model.User;

public interface UserService {
	/**
	 * 
	 * @param username
	 * @return user:[id,username,email,createtime,lastchange,admin]
	 */
	User checkUsername(String username);

	/**
	 * 
	 * @param username
	 * @return user:[id,username,password,salt,admin]
	 */
	User checkLogin(String username);

	String checkEmail(String email);

	List<User> list();

	void add(User user);

	User getById(Integer id);

	void delete(Integer id);

	void update(User user);

	void flushUsers();

}
