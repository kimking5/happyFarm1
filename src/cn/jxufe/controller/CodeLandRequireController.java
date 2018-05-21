package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.CodeLandRequire;
import cn.jxufe.service.CodeLandRequireService;

@Controller
@RequestMapping("/codeLandRequire")
public class CodeLandRequireController
{
	@Autowired
	private CodeLandRequireService codeLandRequireService;
	
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeLandRequire> data() throws Exception
	{
        return codeLandRequireService.findAll();
    }
}