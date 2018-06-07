package cn.jxufe.imp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jxufe.bean.Message;
import cn.jxufe.dao.SeedBagDAO;
import cn.jxufe.dao.SeedDAO;
import cn.jxufe.dao.UserDAO;
import cn.jxufe.entity.Seed;
import cn.jxufe.entity.SeedBag;
import cn.jxufe.entity.User;
import cn.jxufe.service.SeedBagService;

/**
 * 种子背包处理实现类
 */
@Service
public class SeedBagImp implements SeedBagService
{
	/**
	 * 用户数据库接口
	 */
	@Autowired
	private UserDAO userDAO;
	
	/**
	 * 种子数据库接口
	 */
	@Autowired
	private SeedDAO seedDAO;
	
	/**
	 * 种子背包数据库接口
	 */
	@Autowired
	private SeedBagDAO seedBagDAO;
	
	/**
	 * 根据用户名查询种子背包
	 * @param userName 用户名
	 */
	@Override
	public Iterable<SeedBag> findSome(String userName)
	{
		return seedBagDAO.findByUserNameContaining(userName);
	}
	
	/**
	 * 保存种子背包
	 * @param session 从中获取当前用户信息
	 * @param seed 需要保存到种子背包中的种子
	 * @return Message 返回的保存结果信息
	 */
	@Override
	public Message save(HttpSession session, Seed seed)
	{
		Message message = new Message();
		User user = (User) session.getAttribute("user");
		if (user == null)
		{
			message.setCode(-10);
			message.setMsg("请先选择用户！");
		}
		else if (seedDAO.findByCId(seed.getcId()) == null)
		{
			message.setCode(-10);
			message.setMsg("该种子不存在，购买失败！");
		}
		else if (seed.getPrice() > user.getGoldCoin())
		{
			message.setCode(-10);
			message.setMsg("金币不足，购买失败！");
		}
		else
		{
			SeedBag seedBag = null;
			Iterable<SeedBag> s = seedBagDAO.findByUserNameAndCId(user.getName(), seed.getcId());
			if ( s != null)
			{
				for (SeedBag bag : s)
				{
					seedBag = bag;
					break;
				}
				if (seedBag == null)
				{
					seedBag = new SeedBag();
					seedBag.setUserName(user.getName());
					seedBag.setcId(seed.getcId());
					seedBag.setSeedNum(1);
				}
				else
				{
					seedBag.setSeedNum(seedBag.getSeedNum() + 1);
				}
				user.setExp(user.getExp() + seed.getExp());
				user.setGoldCoin(user.getGoldCoin() - seed.getPrice());
				user.setScore(user.getScore() + seed.getScore());
				try
				{
					userDAO.save(user);
					seedBagDAO.save(seedBag);
					message.setCode(0);
					message.setMsg("种子购买成功！");
				}
				catch (Exception e)
				{
					message.setCode(-10);
					message.setMsg("种子购买失败！");
				}
			}
		}
		return message;
	}
}