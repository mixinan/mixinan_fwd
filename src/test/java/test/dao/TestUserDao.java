package test.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cc.guoxingnan.mixinan.dao.UserDao;
import cc.guoxingnan.mixinan.entity.User;
import cc.guoxingnan.mixinan.util.Util;
import test.TestCase;

public class TestUserDao extends TestCase{
	UserDao dao = super.getContext().getBean("userDao", UserDao.class);
	
	@Test
	public void init(){
		System.out.println(dao);
		User user = new User();
		user.setMi_user_name("mixi");
		user.setMi_user_password("123456");
		user.setMi_user_gender("1");
		user.setMi_user_nickname("´óÄ§Íõ");
		user.setMi_user_create_time(Util.getCurrentTime());
		dao.regist(user);
		System.out.println(user);
	}
	
	@Test
	public void check(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "demo");
		map.put("password", "123456");
		
		User user = dao.check(map);
		
		System.out.println(user);
	}
	
	
	@Test
	public void getUserById(){
		User user = dao.getUserById(11);
		System.out.println(user);
	}
	
	
	@Test
	public void checkUsernameUsed(){
		int res = dao.checkNameUsed("mixinan");
		System.out.println(res);
	}
}
