package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.FarmDAO;
import cn.jxufe.entity.User;
import cn.jxufe.service.FarmService;

/**
 * 选择用户Service实现类
 */
@Service
public class FarmImp implements FarmService
{
	/**
	 * 选择用户数据库接口
	 */
	@Autowired
	private FarmDAO farmDAO;

	/**
	 * 查找所有用户
	 */
	@Override
	public Iterable<User> findAll()
	{
		return farmDAO.findAll();
	}
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return User 用户
	 */
	@Override
	public User findUserById(long id)
	{
		return farmDAO.findOne(id);
	}

	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return User 用户
	 */
	@Override
	public User findUserByName(String name)
	{
		return farmDAO.findByName(name);
	}
}