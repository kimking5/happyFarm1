package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.CodeCropStatus;
import cn.jxufe.service.CodeCropStatusService;

@Controller
@RequestMapping("/codeCropStatus")
public class CodeCropStatusController
{
	@Autowired
	private CodeCropStatusService codeCropStatusService;
	
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
   
    public Iterable<CodeCropStatus> data() throws Exception
	{
        return codeCropStatusService.findAll();
    }
}