package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.dao.RelationDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;
import test.service.TestBase;

public class TestRelationDao extends TestBase{
	private RelationDao rdao;
	@Before
	public void init(){
		rdao = getContext().getBean("relationDao",RelationDao.class);
		
	}
	//测试关联多个对象
	@Test
	public void test1(){
		User user = rdao.findUserAndBooks1("48595f52-b22c-4485-9244-f4004255b972");
		List<Book> books = user.getBooks();
		System.out.println(user);
		for (Book book : books) {
			System.out.println(book);
		}
	}
	//测试关联单个对象
	@Test
	public void test2(){
		List<Book> books = rdao.findBookAndUser1();
		for (Book book : books) {
			User user = book.getUser();
			System.out.println(book);
			
		}
	}
}
