package cn.jxufe.service;

import cn.jxufe.entity.CodeCropStatus;

/**
 * 种子生长状态的业务逻辑处理接口
 */
public interface CodeCropStatusService
{
	/**
	 * 查找CodeCropStatus实体
	 * @return CodeCropStatus实体
	 */
	public Iterable<CodeCropStatus> findAll();
}