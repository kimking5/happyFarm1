package cn.jxufe.service;

import javax.servlet.http.HttpSession;

import cn.jxufe.bean.Message;
import cn.jxufe.entity.Seed;
import cn.jxufe.entity.SeedBag;

/**
 * 种子背包业务逻辑处理接口
 */
public interface SeedBagService
{
	/**
	 * 根据用户名查找种子背包
	 * @param userName 用户名
	 * @return SeedBag集合
	 */
	public Iterable<SeedBag> findSome(String userName);
	
	/**
	 * 保存种子背包
	 * @param session 从中获取用户信息
	 * @param seed 需要保存到种子背包的种子实体
	 * @return Message消息实体
	 */
	public Message save(HttpSession session, Seed seed);
}