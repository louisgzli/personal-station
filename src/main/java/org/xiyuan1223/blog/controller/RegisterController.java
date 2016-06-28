package org.xiyuan1223.blog.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xiyuan1223.blog.rest.FormResult;
import org.xiyuan1223.blog.service.StationService;
import org.xiyuan1223.blog.vo.Station;


@Controller
@RequestMapping("/user")
public class RegisterController {
	@Resource
	StationService stationService;
	
	Log log = LogFactory.getLog(getClass());
	/**
	 *直接把表单的参数写在Controller相应的方法的形参中
	 * @param username
	 * @param password
	 */
	@RequestMapping("/addUser1")
	public String addUser(String username,String password){
		System.out.println("注册成功！");
		System.out.println("用户名："+username);
		System.out.println("密码："+password);
		 return "/user/success";
	}
	/**
	 * 通过HttpServletRequest接收
	 * @param request
	 * @return
	 */
	@RequestMapping("/addUser2")
    public String addUser2(HttpServletRequest request) {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("userName is:"+userName);
        System.out.println("password is:"+password);
        return "/user/success";
    }
	@RequestMapping(value="/addUser3",method=RequestMethod.GET)
	public String addUser3(HttpServletRequest request){
		Station user = new Station();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setSex(request.getParameter("sex"));
		user.setInterest(request.getParameter("interest"));
		user.setCity(request.getParameter("city"));
		user.setEmail(request.getParameter("email"));
	
		stationService.insert(user);
		System.out.println("添加成功");
		return "user/sucRegister";
		
	}
	@RequestMapping(value="addUser4",method = RequestMethod.POST)
	public FormResult save( Station station)
	{
		FormResult formResult = new FormResult();
		try
		{
			if (StringUtils.isEmpty(station.getId()))
			{
				stationService.insert(station);
			}
			else
			{
				stationService.update(station);
			}
			formResult.setSuccess(true);
			formResult.setMessage("基站信息保存成功!");
		}
		catch (ConstraintViolationException e)
		{
			formResult.copyErrors(e);
			formResult.setMessage("基站信息校验失败!");
			formResult.setSuccess(false);
		}
		catch (Exception e)
		{
			log.error("Station save failed!", e);
			formResult.setSuccess(false);
			formResult.setMessage(e.getMessage());
		}
		return formResult;
	}
}
