package cn.jxufe.service;

import cn.jxufe.entity.CodeSeedType;

/**
 * 种子的业务逻辑处理接口
 */
public interface CodeSeedTypeService
{
	/**
	 * 查找CodeSeedType
	 * @return CodeSeedType实体
	 */
	public Iterable<CodeSeedType> findAll();
}