package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.dao.CodeCropStatusDAO;
import cn.jxufe.entity.CodeCropStatus;
import cn.jxufe.service.CodeCropStatusService;

@Service
public class CodeCropStatusImp implements CodeCropStatusService
{
	@Autowired
	private CodeCropStatusDAO codeCropStatusDAO;
	
	@Override
	public Iterable<CodeCropStatus> findAll()
	{
		return codeCropStatusDAO.findAll();
	}
}