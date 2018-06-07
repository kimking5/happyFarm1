package cn.jxufe.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.jxufe.entity.SeedBag;

/**
 * 种子背包数据库接口
 */
public interface SeedBagDAO extends PagingAndSortingRepository<SeedBag, Long>
{
	/**
	 * 根据用户名模糊查询种子背包
	 * @param userName 用户名
	 * @return SeedBag集合
	 */
	public Iterable<SeedBag> findByUserNameContaining(String userName);
	
	/**
	 * 根据用户名和种子id查找种子背包
	 * @param userName 用户名
	 * @param cId 种子id
	 * @return SeedBag集合
	 */
	public Iterable<SeedBag> findByUserNameAndCId(String userName, int cId);
}