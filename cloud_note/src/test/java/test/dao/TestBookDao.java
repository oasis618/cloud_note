package test.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;

public class TestBookDao {
	BookDao dao=null;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("bookDao",BookDao.class);
	}
	/**
	 * 测试User findByUserId方法
	 */
	@Test
	public void test1(){
		List<Book> u = dao.findByUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		for (Book book : u) {
			System.out.println(book);
		}
	}
	/**
	 * 测试 save(Book)方法
	 */
	@Test
	public void test2(){
		Book book = new Book();
		book.setCn_user_id("userId123456");
		book.setCn_notebook_id("notebookId123456");
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
		book.setCn_notebook_name("notebookname123456");
		int i = dao.save(book);
		System.out.println(i);
	}
}









