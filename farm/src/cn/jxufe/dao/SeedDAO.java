package cn.jxufe.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import cn.jxufe.entity.Seed;

/**
 * 数据库种子信息查询
 */
public interface SeedDAO extends PagingAndSortingRepository<Seed, Long>
{
	/**
    数据库查询方法
    查找数据库中包含了caption的种子名
@param caption 用于接收一个需要查询的String类型的值
@param pageable 用于接收一个用于分页的Pageable类型的值
@return 返回Seed实体
*/
	public Page<Seed> findByCaptionContaining(Pageable pageable, String caption);
	
	/**
	 * 根据种子id查询种子
	 * @param cID 种子id
	 * @return 种子集合
	 */
	public Iterable<Seed> findByCId(int cID);
}