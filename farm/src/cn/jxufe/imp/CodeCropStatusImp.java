package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.CodeCropStatusDAO;
import cn.jxufe.entity.CodeCropStatus;
import cn.jxufe.service.CodeCropStatusService;

/**
 * CodeCropStatusImp  种子成长阶段描述实现类
 * CodeCropStatusService 实现类所实现的接口
 */
@Service
public class CodeCropStatusImp implements CodeCropStatusService
{
	/**
	 * 创建成长阶段数据访问对象的私有变量
	 */
	@Autowired
	private CodeCropStatusDAO codeCropStatusDAO;
	
	/**
	 * 实现CodeCropStatusService类中的方法
	 * @return CodeCropStatus数据库中获取成长阶段描述表的数据后返回的可迭代对象
	 */
	@Override
	public Iterable<CodeCropStatus> findAll()
	{
		return codeCropStatusDAO.findAll();
	}
}