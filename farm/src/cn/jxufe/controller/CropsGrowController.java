package cn.jxufe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.bean.EasyUIDataPageRequest;
import cn.jxufe.entity.CropsGrow;
import cn.jxufe.service.CropsGrowService;
import net.sf.json.JSONObject;

/**
 * 作物成长控制器
 * 响应对作物成长的请求
 */
@Controller
@RequestMapping("/cropsGrow")
public class CropsGrowController
{
	@Autowired
	private CropsGrowService cropsGrowService;
	
	/**
	 * 跳转页面到cropsGrow/grid.jsp
	 * @return String
	 */
	@RequestMapping(value="grid")
    public String grid()
	{
        return "cropsGrow/grid";
    }
	
	/**
	 * @param pageRequest 分页请求
	 * @param cId 种子id
	 * @return 符合条件CropsGrow
	 */
	@ResponseBody
    @RequestMapping(value="data", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CropsGrow> gridData(EasyUIDataPageRequest pageRequest,
    		@RequestParam(defaultValue="1") int cId)
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
        return cropsGrowService.findSome(cId, new Sort(orders));
    }
	
	/**
	 * 根据用户名查找用户
	 * @param name 用户名
	 * @return User
	 */
	@ResponseBody
    @RequestMapping(value="cropStep", produces = MediaType.APPLICATION_JSON_VALUE)
    public CropsGrow find(@RequestParam int cId, @RequestParam(defaultValue="5")int status)
    {
        return cropsGrowService.findByCIdAndGrowCaption(cId, status);
    }
	
	/**
	 * 保存新的作物成长实体
	 * @param cropsGrow 作物成长
	 * @return String
	 */
	@ResponseBody
    @RequestMapping(value="save")
    public String save(CropsGrow cropsGrow)
    {
        return JSONObject.fromObject(cropsGrowService.save(cropsGrow)).toString();
    }
    
	/**
	 * 删除作物成长实体
	 * @param cropsGrow 作物成长
	 * @return String
	 */
    @ResponseBody
    @RequestMapping(value="delete")
    public String delete(CropsGrow cropsGrow)
    {
        return JSONObject.fromObject(cropsGrowService.delete(cropsGrow)).toString();
    }
}