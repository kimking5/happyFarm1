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

@Controller
@RequestMapping("/cropsGrow")
public class CropsGrowController
{
	@Autowired
	private CropsGrowService cropsGrowService;
	
	@RequestMapping(value="grid")
    public String grid()
	{
        return "cropsGrow/grid";
    }
	
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
	
	@ResponseBody
    @RequestMapping(value="save")
    public String save(CropsGrow cropsGrow)
    {
        return JSONObject.fromObject(cropsGrowService.save(cropsGrow)).toString();
    }
    
    @ResponseBody
    @RequestMapping(value="delete")
    public String delete(CropsGrow cropsGrow)
    {
        return JSONObject.fromObject(cropsGrowService.delete(cropsGrow)).toString();
    }
}