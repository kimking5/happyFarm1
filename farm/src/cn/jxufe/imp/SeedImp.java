package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.Message;
import cn.jxufe.dao.SeedDAO;
import cn.jxufe.entity.Seed;
import cn.jxufe.service.SeedService;

/**
 * SeedImp 种子实现类
 * SeedService 实现类所实现的接口
 */
@Service
public class SeedImp implements SeedService
{
	/**
	 * 创建种子数据访问对象的私有变量
	 */
	@Autowired
	private SeedDAO seedDAO;
	
	/**
	 * 通过种子名称查询数据，并返回分页数据
	 * pageable 分页变量
	 * caption 用于通过种子名称查询的字符串变量
	 * @return Seed 通过种子名称查询数据后返回查询数据与分页信息
	 */
	@Override
	public EasyUIData<Seed> findSome(Pageable pageable, String caption)
	{
		Page<Seed> page = seedDAO.findByCaptionContaining(pageable, caption);
        EasyUIData<Seed> easyUIData = new EasyUIData<Seed>();
        easyUIData.setTotal(page.getTotalElements());
        easyUIData.setRows(page.getContent());
        return easyUIData;
	}

	/**
	 * 保存种子数据后的信息提示方法
	 * seed 种子实体对象
	 * @return Message 根据执行成功与否返回message
	 */
	@Override
	public Message save(Seed seed)
	{
		Message message = new Message();
        try
        {
            seedDAO.save(seed);
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
	 * 删除种子数据后的信息提示方法
	 * seed 种子实体对象
	 * @return Message 根据执行成功与否返回message
	 */
	@Override
	public Message delete(Seed seed)
	{
		Message message = new Message();
        try
        {
        	seedDAO.delete(seed);
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