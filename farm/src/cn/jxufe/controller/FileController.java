package cn.jxufe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.jxufe.bean.Message;
import cn.jxufe.utils.FileSaver;

/**
 * 文件控制器
 * 响应对上传文件的请求
 */
@Controller
@RequestMapping("file")
public class FileController
{
	/**
	 * @param request 前台请求
	 * @param uploadFile 需要上传的文件
	 * @return Message消息
	 */
	@ResponseBody
    @RequestMapping(value="saveHeadImg", produces = MediaType.APPLICATION_JSON_VALUE)
    public Message saveHeadImg(HttpServletRequest request, @RequestParam("filePathName") MultipartFile uploadFile)
    {
        return FileSaver.save("images/headImages/", request, uploadFile);
    }
}