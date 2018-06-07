package cn.jxufe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.bean.Message;
import cn.jxufe.entity.Seed;
import cn.jxufe.entity.SeedBag;
import cn.jxufe.service.SeedBagService;

/**
 * 种子背包请求控制类
 */
@Controller
@RequestMapping("/seedBag")
public class SeedBagController
{
	/**
	 * 粽种子背包Service
	 */
	@Autowired
	private SeedBagService seedBagService;

	/**
	 * 获取种子背包
	 * @param request 请求实体
	 * @param model 保存用户信息
	 * @return String
	 */
	@RequestMapping(value="grid")
    public String grid(HttpServletRequest request, Model model)
	{
		String userName = request.getParameter("userName");
		model.addAttribute("userName", userName);
        return "seedBag/grid";
    }
	
	/**
	 * 获取指定用户的背包
	 * @param userName 同户名
	 * @return SeedBag 符合条件的种子背包集合
	 */
	@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Iterable<SeedBag> data(@RequestParam(defaultValue="") String userName)
	{
		return seedBagService.findSome(userName);
	}
	
	/**
	 * 更新种子背包中的种子信息
	 * @param session 从中获取用户信息
	 * @param seed 种子信息
	 * @return Message
	 */
	@RequestMapping(value = "save", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@Transactional
	public Message save(HttpSession session, @RequestBody Seed seed)
	{
		return seedBagService.save(session, seed);
	}
}