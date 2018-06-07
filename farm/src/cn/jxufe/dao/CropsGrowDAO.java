package cn.jxufe.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.jxufe.entity.CropsGrow;

/** 作物成长数据库接口类
 *@version V1.0
 */
public interface CropsGrowDAO extends JpaRepository<CropsGrow, Long>
{
	/**
	 * 数据库查询方法
	 * 根据cId查找数据库中种子数据
     * @param cId 用于接收一个需要查询的String类型的值
	 * @param sort 用于接收一个用于分页的Sort类型的值
	 * @return 返回CropsGrow实体
	 */
	public List<CropsGrow> findByCId(int cId, Sort sort);
	
	/**
	 * 根据种子id和成长标题获取种子成长阶段
	 * @param cId 种子id
	 * @param status 种子成长状态
	 * @return CropsGrow 种子成长阶段
	 */
	public CropsGrow findByCIdAndStatus(int cId, int status);
}