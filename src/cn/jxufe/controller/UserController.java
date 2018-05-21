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

@Controller
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="grid")
    public String grid()
	{
        return "user/grid";
    }
	
	@ResponseBody
    @RequestMapping(value="data", produces = MediaType.APPLICATION_JSON_VALUE)
    public EasyUIData<?> captionGridData(EasyUIDataPageRequest pageRequest,
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
    
    @ResponseBody
    @RequestMapping(value="save")
    public String save(User user)
    {
        return JSONObject.fromObject(userService.save(user)).toString();
    }
    
    @ResponseBody
    @RequestMapping(value="delete")
    public String delete(User user)
    {
        return JSONObject.fromObject(userService.delete(user)).toString();
    }
}