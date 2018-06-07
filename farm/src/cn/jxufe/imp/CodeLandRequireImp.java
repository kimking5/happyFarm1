package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.CodeLandRequireDAO;
import cn.jxufe.entity.CodeLandRequire;
import cn.jxufe.service.CodeLandRequireService;

/**
 * CodeLandRequireImp 土地需求实现类
 * CodeLandRequireService 实现类所实现的接口
 */
@Service
public class CodeLandRequireImp implements CodeLandRequireService
{
	/**
	 * 创建土地需求数据访问对象的私有变量
	 */
	@Autowired
	private CodeLandRequireDAO codeLandRequireDAO;

	/**
	 * 实现CodeLandRequireService类中的方法
	 * @return CodeLandRequire 数据库中获取土地需求表的数据后返回的可迭代对象
	 */
	@Override
	public Iterable<CodeLandRequire> findAll()
	{
		return codeLandRequireDAO.findAll();
	}
}