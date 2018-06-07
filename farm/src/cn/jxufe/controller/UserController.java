package cn.jxufe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.bean.EasyUIData;
import cn.jxufe.bean.EasyUIDataPageRequest;
import cn.jxufe.entity.User;
import cn.jxufe.service.UserService;
import net.sf.json.JSONObject;

/**
 * 用户请求控制器
 * 响应对用户信息的请求
 */
@Controller
@RequestMapping("/user")
public class UserController
{
	/**
	 * 用户Service
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 跳转到用户页面
	 * @return String
	 */
	@RequestMapping(value="grid")
    public String grid()
	{
        return "user/grid";
    }
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return User
	 */
	@ResponseBody
    @RequestMapping(value="user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User findUser(@RequestParam(defaultValue="")String name)
    {
		Iterable<User> us = userService.findByName(name);
		User user = null;
		for (User u : us)
		{
			user = u;
			break;
		}
        return user;
    }
	
	/**
	 * 查询所有用户
	 * @param pageRequest分叶请求
	 * @param name 用户名
	 * @return User实体集合
	 */
	@ResponseBody
    @RequestMapping(value="data", produces = MediaType.APPLICATION_JSON_VALUE)
    public EasyUIData<?> userGridData(EasyUIDataPageRequest pageRequest,
    		@RequestParam(defaultValue="")String name)
    {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        if(pageRequest.getOrder().equals("asc"))
        {
            orders.add(new Sort.Order(Direction.ASC, pageRequest.getSort()));
        }
        else
        {
            orders.add(new Sort.Order(Direction.DESC, pageRequest.getSort()));
        }
        Pageable pageable = new PageRequest(pageRequest.getPage()-1, pageRequest.getRows(), new Sort(orders));
        return userService.findSome(pageable, name);
    }
	
	/**
	 * 保存用户
	 * @param user 需要保存的用户
	 * @return String 结果消息
	 */
    @ResponseBody
    @RequestMapping(value="save")
    public String save(User user)
    {
        return JSONObject.fromObject(userService.save(user)).toString();
    }
    
    /**
     * 删除用户
     * @param user 需要删除的用户
     * @return String 结果消息
     */
    @ResponseBody
    @RequestMapping(value="delete")
    public String delete(User user)
    {
        return JSONObject.fromObject(userService.delete(user)).toString();
    }
}