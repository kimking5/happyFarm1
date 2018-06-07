package cn.jxufe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.jxufe.entity.User;

/**
 * 农场用户选择数据库接口
 */
public interface FarmDAO extends PagingAndSortingRepository<User, Long>
{
	/**
	 * 根据姓名模糊查找用户
	 * @param pageable 分页
	 * @param name 用户名
	 * @return User分页集合
	 */
	public Page<User> findByNameContaining(Pageable pageable, String name);
	
	/**
	 * 根据姓名查找用户
	 * @param name 用户名
	 * @return User用户
	 */
	public User findByName(String name);
}