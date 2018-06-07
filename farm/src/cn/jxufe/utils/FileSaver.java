package cn.jxufe.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import cn.jxufe.bean.Message;

/**
 * 文件上上传工具类
 */
public class FileSaver
{
	/**
	 * 上传文件到指定路径，返回结果消息
	 * @param path 文件保存路径 String
	 * @param request 请求实体 HttpServletRequest类型类型
	 * @param uploadFile 需要上传的文件 MultipartFile类型
	 * @return Message
	 */
	public static Message save(String path, HttpServletRequest request, MultipartFile uploadFile)
	{
		Message message = new Message();
		String basePath = request.getSession().getServletContext().getRealPath(path);
		String fileName = uploadFile.getOriginalFilename();
		File targetFile = new File(basePath, fileName);
		if(!targetFile.exists())
		{
			targetFile.mkdirs();
		}
		try
		{
			uploadFile.transferTo(targetFile);
			message.setCode(0);
            message.setMsg("上传成功");
		}
		catch (IllegalStateException | IOException e)
		{
			 message.setCode(-10);
	         message.setMsg("上传失败");
		}
		return message;
	}
}