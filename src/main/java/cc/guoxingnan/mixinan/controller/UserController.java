package cc.guoxingnan.mixinan.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cc.guoxingnan.mixinan.entity.User;
import cc.guoxingnan.mixinan.service.UserService;
import cc.guoxingnan.mixinan.util.MixiResult;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	UserService service;
	
	@RequestMapping("/getUserById.do")
	@ResponseBody
	public MixiResult<User> execute(int id){
		MixiResult<User> result = service.getUserById(id);
		return result;
	}

	
	
	/**
	 * 查看 name 有没有被占用
	 * @param name
	 * @return
	 */
	@RequestMapping("/checkNameUsed.do")
	@ResponseBody
	public MixiResult<Integer> checkNameUsed(String name){
		MixiResult<Integer> result = service.checkNameUsed(name);
		return result;
	}
	
	
	
	@RequestMapping("/regist.do")
	@ResponseBody
	public MixiResult<User> regist(String name,String password,String gender,String nickname){
		if (nickname==null) {
			nickname=name;
		}
		MixiResult<User> result = service.regist(name, password, gender,nickname);
		return result;
	}
	
	
	
	@RequestMapping("/login.do")
	@ResponseBody
	public MixiResult<User> execute(String name,String password){
		MixiResult<User> result = service.check(name, password);
		return result;
	}
	
}
