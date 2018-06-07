package cn.jxufe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.entity.CodeCropStatus;
import cn.jxufe.service.CodeCropStatusService;

/**
 * 作物状态控制器
 * 响应对作物状态的请求
 */
@Controller
@RequestMapping("/codeCropStatus")
public class CodeCropStatusController
{
	/**
	 * 作物状态Service
	 */
	@Autowired
	private CodeCropStatusService codeCropStatusService;
	
	/**
	 * @return CodeCropStatus实体
	 * @throws 抛出Exception
	 */
	@ResponseBody
	@RequestMapping(value="/data",produces=MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CodeCropStatus> data() throws Exception
	{
        return codeCropStatusService.findAll();
    }
}