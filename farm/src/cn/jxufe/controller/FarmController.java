package cn.jxufe.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.User;
import cn.jxufe.service.FarmService;

/**
 * 选择用户控制器
 */
@Controller
@RequestMapping("/selectUser")
public class FarmController
{
	/**
	 * 选择用户功能Service
	 */
	@Autowired
	private FarmService farmService;
	
	/**
	 * 跳转界面到farm/grid
	 * return String
	 */
	@RequestMapping(value="grid")
    public String grid()
	{
        return "farm/grid";
    }
	
	/**
	 * 查询所有用户
	 * @return 用户集合
	 */
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> data()
	{
        return farmService.findAll();
    }
	
	/**
	 * 根据id查找用户
	 * @param session 保存当前用户信息
	 * @param id 用户id
	 * @return User
	 */
	@ResponseBody
	@RequestMapping(value="/setCurrentUser",produces=MediaType.APPLICATION_JSON_VALUE)
    public User findById(HttpSession session, long id)
	{
		User user = farmService.findUserById(id);
		session.setAttribute("user", user);
        return user;
    }
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户姓名
	 * @return User
	 */
	@ResponseBody
	@RequestMapping(value="/findByName",produces=MediaType.APPLICATION_JSON_VALUE)
    public User findByName(String name)
	{
        return farmService.findUserByName(name);
    }
}