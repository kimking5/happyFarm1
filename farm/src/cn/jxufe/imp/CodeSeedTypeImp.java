package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.CodeSeedTypeDAO;
import cn.jxufe.entity.CodeSeedType;
import cn.jxufe.service.CodeSeedTypeService;

/**
 * CodeSeedTypeImp 种子类型实现类
 * CodeSeedTypeService 实现类所实现的接口
 */
@Service
public class CodeSeedTypeImp implements CodeSeedTypeService
{
	/**
	 * 创建种子类型数据访问对象的私有变量
	 */
	@Autowired
	private CodeSeedTypeDAO codeSeedTypeDAO;
	
	/**
	 * 实现CodeLandRequireService类中的方法
	 * @return CodeSeedType 数据库中获取种子类型表的数据后返回的可迭代对象
	 */
	@Override
	public Iterable<CodeSeedType> findAll()
	{
		return codeSeedTypeDAO.findAll();
	}
}