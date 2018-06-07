package cn.jxufe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.jxufe.entity.User;

/** 用户数据库接口类
 *	@version V1.0
 */
public interface UserDAO extends PagingAndSortingRepository<User, Long>
{
	/**
	 * 数据库查询方法
     * 查找数据库中包含了name的用户名
     * @param name 用于接收一个需要查询的String类型的值
     * @param pageable 用于接收一个用于分页的Pageable类型的值
     * @return 返回User实体
	 */
	public Page<User> findByNameContaining(Pageable pageable, String name);
	
	/**
	 * 根据姓名查找用户
	 * @param name 用户名
	 * @return User集合
	 */
	public Iterable<User> findByName(String name);
}