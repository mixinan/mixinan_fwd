package cc.guoxingnan.mixinan.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cc.guoxingnan.mixinan.dao.UserDao;
import cc.guoxingnan.mixinan.entity.User;
import cc.guoxingnan.mixinan.util.MixiResult;
import cc.guoxingnan.mixinan.util.Util;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource
	UserDao dao;

	public MixiResult<User> regist(String name, String password, String gender, String nickname) {
		User user = new User();
		user.setMi_user_create_time(Util.getCurrentTime());
		user.setMi_user_nickname(nickname);
		user.setMi_user_gender(gender);
		user.setMi_user_name(name);
		user.setMi_user_password(password);
		
		dao.regist(user);
		MixiResult<User> result = new MixiResult<User>();
		
		result.setStatus(0);
		result.setMsg("注册成功");
		result.setData(user);
		
		return result;
	}

	public MixiResult<User> check(String name, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("password", password);
		
		User user = dao.check(map);
		
		MixiResult<User> result = new MixiResult<User>();
		if (user == null) {
			result.setStatus(1);
			result.setMsg("账号或密码错误");
		}else{
			result.setStatus(0);
			result.setMsg("用户验证成功");
			result.setData(user);
		}
		
		return result;
	}

	public MixiResult<User> getUserById(int id) {
		User user = dao.getUserById(id);
		
		MixiResult<User> res = new MixiResult<User>();
		
		if (user==null) {
			res.setStatus(1);
			res.setMsg("没有查询到id对应的用户");
		}else{
			res.setStatus(0);
			res.setMsg("ok");
			res.setData(user);
		}
		
		return res;
	}

	public MixiResult<Integer> checkNameUsed(String name) {
		int rows = dao.checkNameUsed(name);
		
		MixiResult<Integer> res = new MixiResult<Integer>();
		if (rows==0) {
			//可以使用
			res.setStatus(0);
			res.setMsg("ok");
		}else{
			//已经被占用
			res.setStatus(1);
			res.setMsg("fail");
		}
		res.setData(rows);

		return res;
	}

}
