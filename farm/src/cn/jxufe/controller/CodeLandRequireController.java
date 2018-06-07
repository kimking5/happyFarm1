package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.CodeLandRequire;
import cn.jxufe.service.CodeLandRequireService;

/**
 * 土地需求控制器
 * 响应对土地需求的请求
 */
@Controller
@RequestMapping("/codeLandRequire")
public class CodeLandRequireController
{
	/**
	 * 土地需求Service
	 */
	@Autowired
	private CodeLandRequireService codeLandRequireService;
	
	/**
	 * @return CodeLandRequire实体
	 */
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeLandRequire> data()
	{
        return codeLandRequireService.findAll();
    }
}