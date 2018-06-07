package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jxufe.service.LandService;

@Controller
@RequestMapping("/land")
public class LandController {
	@Autowired
	private LandService landService;
	
	
	@RequestMapping(value="grid")
    public String grid()
	{
        return "land/grid";
    }
}
