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
import cn.jxufe.entity.Seed;
import cn.jxufe.service.SeedService;
import net.sf.json.JSONObject;

/**
 * 种子控制器
 * 响应对种子的请求
 */
@Controller
@RequestMapping("/seed")
public class SeedController
{
	/**
	 * 种子Service
	 */
	@Autowired
	private SeedService seedService;
	
	/**
	 * 跳转页面到seed/grid.jsp
	 * @return String
	 */
	@RequestMapping(value="grid")
    public String grid()
	{
        return "seed/grid";
    }
	
	@RequestMapping(value="warehouse")
    public String warehouse()
	{
        return "seed/warehouse";
    }
	
	/**
	 * 
	 * @param pageRequest 分页请求
	 * @param caption 种子名称
	 * @return 符合条件的种子
	 */
	@ResponseBody
    @RequestMapping(value="data", produces = MediaType.APPLICATION_JSON_VALUE)
    public EasyUIData<?> captionGridData(EasyUIDataPageRequest pageRequest,
    		@RequestParam(defaultValue="")String caption)
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
        return seedService.findSome(pageable, caption);
    }
    
	/**
	 * 保存新的种子实体
	 * @param seed 要保存的种子
	 * @return String
	 */
    @ResponseBody
    @RequestMapping(value="save")
    public String save(Seed seed)
    {
        return JSONObject.fromObject(seedService.save(seed)).toString();
    }
    
    /**
	 * 删除新的种子实体
	 * @param seed 要删除的种子
	 * @return String
	 */
    @ResponseBody
    @RequestMapping(value="delete")
    public String delete(Seed seed)
    {
        return JSONObject.fromObject(seedService.delete(seed)).toString();
    }
}