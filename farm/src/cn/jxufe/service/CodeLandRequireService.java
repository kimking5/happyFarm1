package cn.jxufe.service;

import cn.jxufe.entity.CodeLandRequire;

/**
 * 土地需求的业务逻辑处理接口
 */
public interface CodeLandRequireService
{
	/**
	 * 查找CodeLandRequire
	 * @return CodeLandRequire实体
	 */
	public Iterable<CodeLandRequire> findAll();
}