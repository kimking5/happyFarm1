package cn.jxufe.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import cn.jxufe.bean.Message;
import cn.jxufe.entity.CropsGrow;

/**
 * 种子成长阶段的业务逻辑处理接口
 */
public interface CropsGrowService
{
	/**
	 * @param cId 种子id
	 * @param sort 排序规则
	 * @return CropsGrow实体
	 */
	public List<CropsGrow> findSome(int cId, Sort sort);
	
	/**
	 * 根据种子id和成长标题获取种子成长阶段
	 * @param cId 种子id
	 * @param growCaption 种子成长标题
	 * @return CropsGrow 种子成长阶段
	 */
	public CropsGrow findByCIdAndGrowCaption(int cId, int status);
	
	/**
	 * @param cropsGrow 需要保存的种子成长阶段
	 * @return Message
	 */
	public Message save(CropsGrow cropsGrow);
	
	/**
	 * @param cropsGrow 需要删除的种子成长阶段
	 * @return Message
	 */
	public Message delete(CropsGrow cropsGrow);
}