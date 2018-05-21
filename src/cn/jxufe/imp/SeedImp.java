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

@Service
public class SeedImp implements SeedService
{
	@Autowired
	private SeedDAO seedDAO;
	
	@Override
	public EasyUIData<Seed> findSome(Pageable pageable, String caption)
	{
		Page<Seed> page = seedDAO.findByCaptionContaining(pageable, caption);
        EasyUIData<Seed> easyUIData = new EasyUIData<Seed>();
        easyUIData.setTotal(page.getTotalElements());
        easyUIData.setRows(page.getContent());
        return easyUIData;
	}

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