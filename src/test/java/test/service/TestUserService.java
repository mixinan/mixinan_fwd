package test.service;

import org.junit.Before;
import org.junit.Test;

import cc.guoxingnan.mixinan.entity.User;
import cc.guoxingnan.mixinan.service.UserService;
import cc.guoxingnan.mixinan.util.MixiResult;
import test.TestCase;

public class TestUserService extends TestCase{
	UserService service;
	
	@Before
	public void init(){
		service = super.getContext().getBean("userService", UserService.class);
	}
	
	@Test
	public void regist(){
		MixiResult<User> result = service.regist("777", "777", "1","¹þ¹þ");
		System.out.println(result.getMsg());
		System.out.println(result.getData());
	}
	
	
	@Test
	public void check(){
		MixiResult<User> result = service.check("111", "111");
		System.out.println(result.getData());
	}
	
	
	@Test
	public void getUserById(){
		MixiResult<User> result = service.getUserById(11);
		System.out.println(result.getData());
	}
	
	@Test
	public void checkNameUsed(){
		MixiResult<Integer> res = service.checkNameUsed("mixinan");
		System.out.println(res);
	}
}
