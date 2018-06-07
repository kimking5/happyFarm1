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

/**
 * UserImp 用户实现类
 * UserService 实现类所实现的接口
 */
@Service
public class UserImp implements UserService
{
	/**
	 * 用户数据库接口
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return User集合
	 */
	@Override
	public Iterable<User> findByName(String name)
	{
		return userDAO.findByName(name);
	}
	
	/**
	 * 根据用户名分页查找用户
	 * @param pageable 分页
	 * @param name 用户名
	 * @return User集合
	 */
	@Override
    public EasyUIData<User> findSome(Pageable pageable, String name)
	{
        Page<User> page = userDAO.findByNameContaining(pageable, name);
        EasyUIData<User> easyUIData = new EasyUIData<User>();
        easyUIData.setTotal(page.getTotalElements());
        easyUIData.setRows(page.getContent());
        return easyUIData;
    }
	
	/**
	 * 保存用户
	 * @param user 需要保存的用户实体
	 * @return Message 保存结果信息
	 */
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
    
    /**
	 * 删除用户
	 * @param user 需要删除的用户实体
	 * @return Message 删除结果信息
	 */
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