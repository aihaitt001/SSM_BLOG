package springmvc.mapper;

import java.util.List;

import springmvc.model.User;

public interface UsersMapper {
	public User checkLogin(String username);

	public User checkUsername(String username);

	public String checkEmail(String email);

	public int add(User user);

	public void delete(Integer id);

	public List<User> list();

	public User getById(Integer id);

	public void update(User user);

}
