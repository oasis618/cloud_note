package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestUserService {
	UserService service;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		 service = ac.getBean("userService",UserService.class);
	}
	//1.checkLogin测试无此用户名
	@Test
	public void test1(){
		NoteResult<User> rs = service.checkLogin("dem", "123");
		System.out.println(rs);
	}
	//2.checkLogin测试密码有误
	@Test
	public void test2(){
		NoteResult<User> rs = service.checkLogin("demo", "111");
		System.out.println(rs);
	}
	//3.checkLogin测试登录成功
	@Test
	public void test3(){
		NoteResult<User> rs = service.checkLogin("demo", "133");
		System.out.println(rs);
	}
	//4.addUser测试用户名已占用
	@Test
	public void test4(){
		NoteResult<Object> rs = service.addUser("demo", "nickname", "password");
		
		System.out.println(rs);
	}
	//5.addUser测试用户注册成功
	@Test
	public void test5(){
		NoteResult<Object> rs = service.addUser("bbb", "nickname", "password");
		System.out.println(rs);
	}
	//6.测试checkPwd
	@Test
	public void test6(){
		NoteResult<Object> rs = service.checkPassword("48595f52-b22c-4485-9244-f4004255b972", "123456");
		System.out.println(rs.getMsg());
	}
	//7.测试changePwd
	@Test
	public void test7(){
		NoteResult<Object> rs = service.changePassword("001", "4QrcOUm6Wau+VuBX8g+IPg==");
		System.out.println(rs.getMsg());
	}
}
