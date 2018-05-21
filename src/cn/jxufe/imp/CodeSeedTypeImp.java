package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.CodeSeedTypeDAO;
import cn.jxufe.entity.CodeSeedType;
import cn.jxufe.service.CodeSeedTypeService;

@Service
public class CodeSeedTypeImp implements CodeSeedTypeService
{
	@Autowired
	private CodeSeedTypeDAO codeSeedTypeDAO;
	
	@Override
	public Iterable<CodeSeedType> findAll()
	{
		return codeSeedTypeDAO.findAll();
	}
}