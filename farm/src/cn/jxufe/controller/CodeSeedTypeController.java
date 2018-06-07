package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.CodeSeedType;
import cn.jxufe.service.CodeSeedTypeService;

/**
 * 种子类型控制器
 * 响应对种子类型的请求
 */
@Controller
@RequestMapping("/codeSeedType")
public class CodeSeedTypeController
{
	@Autowired
	private CodeSeedTypeService codeSeedTypeService;
	
	/**
	 * @return CodeSeedType实体
	 * @throws 抛出Exception
	 */
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeSeedType> data() throws Exception
	{
        return codeSeedTypeService.findAll();
    }
}