package springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import springmvc.model.User;

public interface UsersMapper {
	public int add(User user);
	public void delete(String username);
	public List<User> list();
	public User getByUsername(String username);
	public void update(@Param(value="id")int id,@Param(value="username")String username);

}
