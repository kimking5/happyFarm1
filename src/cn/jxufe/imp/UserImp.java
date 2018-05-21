package cn.jxufe.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.Message;
import cn.jxufe.dao.UserDAO;
import cn.jxufe.entity.User;
import cn.jxufe.service.UserService;

@Service
public class UserImp implements UserService
{
	@Autowired
	private UserDAO userDAO;
	
	@Override
    public EasyUIData<User> findSome(Pageable pageable, String name)
	{
        Page<User> page = userDAO.findByNameContaining(pageable, name);
        EasyUIData<User> easyUIData = new EasyUIData<User>();
        easyUIData.setTotal(page.getTotalElements());
        easyUIData.setRows(page.getContent());
        return easyUIData;
    }
	
    @Override
    public Message save(User user)
    {
        Message message = new Message();
        try
        {
            userDAO.save(user);
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
    public Message delete(User user)
    {
        Message message = new Message();
        try
        {
            userDAO.delete(user);
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