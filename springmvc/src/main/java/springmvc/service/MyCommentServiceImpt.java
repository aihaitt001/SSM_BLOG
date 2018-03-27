package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.MyCommentMapper;
import springmvc.model.MyComment;

@Service
public class MyCommentServiceImpt implements MyCommentService {

	@Autowired
	MyCommentMapper mapper;

	@Override
	public List<MyComment> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(MyComment record) {
		// TODO Auto-generated method stub
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(MyComment record) {
		// TODO Auto-generated method stub
		return mapper.insertSelective(record);
	}

	@Override
	public MyComment selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(MyComment record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MyComment record) {
		// TODO Auto-generated method stub
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<MyComment> listByParentid(int parentid) {
		// TODO Auto-generated method stub
		return mapper.listByParentid(parentid);
	}

}
