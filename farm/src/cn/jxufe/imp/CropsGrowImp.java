package cn.jxufe.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.Message;
import cn.jxufe.dao.CropsGrowDAO;
import cn.jxufe.entity.CropsGrow;
import cn.jxufe.service.CropsGrowService;

/**
 * CropsGrowImp 种子成长阶段实现类
 * CropsGrowService 实现类所实现的接口
 */
@Service
public class CropsGrowImp implements CropsGrowService
{
	/**
	 * 创建种子成长阶段数据访问对象的私有对象
	 */
	@Autowired
	private CropsGrowDAO cropsGrowDAO;
	
	/**
	 * cId 种子ID
	 * @return CropsGrow实体 通过种子ID查询获取数据，并返回一个list对象
	 */
	@Override
	public List<CropsGrow> findSome(int cId, Sort sort)
	{
		return cropsGrowDAO.findByCId(cId, sort);
	}
	
	/**
	 * 保存种子成长阶段数据后的信息提示方法
	 * cropsGrow 种子成长阶段实体对象
	 * @return Message 根据执行成功与否返回message
	 */
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
	
	/**
	 * 删除种子成长阶段数据后的信息提示方法
	 * cropsGrow 种子成长阶段实体对象
	 * @return Message 根据执行成功与否返回message
	 */
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

	@Override
	public CropsGrow findByCIdAndGrowCaption(int cId, int status)
	{
		return cropsGrowDAO.findByCIdAndStatus(cId, status);
	}
}