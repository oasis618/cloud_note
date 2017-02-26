package test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;

public class TestUserDao {
	UserDao dao=null;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("userDao",UserDao.class);
	}
	@Test
	public void test1(){
		User user = dao.findByName("demo");
		System.out.println(user);
	}
	@Test
	public void test2(){
		User user = new User();
		user.setCn_user_id("001");
		user.setCn_user_name("zzq");
		user.setCn_user_nick("007");
		user.setCn_user_password("123");
		dao.save(user);
		System.out.println("done");
	}
	@Test
	public void test3(){
		User user = dao.checkPassword("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(user);
	}
	@Test
	public void test4(){
		User user = new User();
		user.setCn_user_id("001");
		user.setCn_user_password("123456");
		int i = dao.changePassword(user);
		System.out.println(i);
	}
}
