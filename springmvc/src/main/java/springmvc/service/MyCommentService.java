package springmvc.service;

import java.util.List;

import springmvc.model.MyComment;

public interface MyCommentService {
	List<MyComment> list();

	List<MyComment> listByParentid(int parentid);

	int deleteByPrimaryKey(Integer id);

	int insert(MyComment record);

	int insertSelective(MyComment record);

	MyComment selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MyComment record);

	int updateByPrimaryKey(MyComment record);
}
