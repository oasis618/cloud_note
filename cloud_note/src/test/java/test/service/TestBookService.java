package test.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestBookService extends TestBase{
	BookService service;
	@Before
	public void init(){
		 service = getContext().getBean("bookService",BookService.class);
	}
	
	@Test
	public void test1(){
		NoteResult<List<Book>> nr = service.loadUserBooks("03590914-a934-4da9-ba4d-b41799f917d1");
		System.out.println(nr.getMsg());
	}
	@Test
	public void test2(){
		Book book = new Book();
		book.setCn_user_id("userId123456");
		book.setCn_notebook_id("notebookId123456");
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
		book.setCn_notebook_name("notebookname123456");
		NoteResult rs = service.addBook(book);
		System.out.println(rs.getMsg());
	}
}
