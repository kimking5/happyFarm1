package cn.jxufe.service;

import org.springframework.data.domain.Pageable;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.Message;
import cn.jxufe.entity.User;

/**
 * 用户的业务逻辑处理接口
 */
public interface UserService
{
	/**
	 * @param pageable 分页
	 * @param name 用户名
	 * @return User实体
	 */
	public Iterable<User> findByName(String name);
	public EasyUIData<User> findSome(Pageable pageable, String name);
	/**
	 * @param user 需要保存的用户实体
	 * @return Message
	 */
	public Message save(User user);
	
	/**
	 * @param user 需要删除的用户实体
	 * @return Message
	 */
	public Message delete(User user);
}