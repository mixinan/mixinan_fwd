package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCase {
	String[] conf = {"conf/spring-mvc.xml","conf/spring-mybatis.xml"};
	ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
	
	public ApplicationContext getContext(){
		return ac;
	}
}
