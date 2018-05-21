package cn.jxufe.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.Message;
import cn.jxufe.dao.CropsGrowDAO;
import cn.jxufe.entity.CropsGrow;
import cn.jxufe.service.CropsGrowService;

@Service
public class CropsGrowImp implements CropsGrowService
{
	@Autowired
	private CropsGrowDAO cropsGrowDAO;
	
	@Override
	public List<CropsGrow> findSome(int cId, Sort sort)
	{
		return cropsGrowDAO.findByCId(cId, sort);
	}
	
	@Override
	public Message save(CropsGrow cropsGrow)
	{
		Message message = new Message();
        try
        {
        	cropsGrowDAO.save(cropsGrow);
            message.setCode(0);
            message.setMsg("保存成功");
        }
        catch(Exception e)
        {
            message.setCode(-10);
            message.setMsg("保存失败");
        }
        return message;
	}

	@Override
	public Message delete(CropsGrow cropsGrow)
	{
		Message message = new Message();
        try
        {
        	cropsGrowDAO.delete(cropsGrow);
            message.setCode(0);
            message.setMsg("删除成功");
        }
        catch(Exception e)
        {
            message.setCode(-10);
            message.setMsg("删除失败");
        }
        return message;
	}
}