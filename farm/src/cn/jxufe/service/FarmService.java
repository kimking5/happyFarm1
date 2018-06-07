package cn.jxufe.service;

import cn.jxufe.entity.User;

/**
 * 选择用户业务逻辑处理接口
 */
public interface FarmService
{
	/**
	 * 查询所有用户
	 * @return User集合
	 */
	public Iterable<User> findAll();
	
	/**
	 * 根据id查找用户
	 * @param id
	 * @return User用户
	 */
	public User findUserById(long id);
	
	/**
	 * 根据id用户名查找用户
	 * @param name 用户名
	 * @return User
	 */
	public User findUserByName(String name);
}