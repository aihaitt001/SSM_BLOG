package springmvc.mapper;

import java.util.List;

import springmvc.model.User;

public interface UsersMapper {
	public String checkUsername(String username);
	
	public int add(User user);
	public void delete(Integer id);
	public List<User> list();
	public User getById(Integer id);
	public void update(User user);

}