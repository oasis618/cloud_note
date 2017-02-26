package cn.tedu.cloud_note.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource(name="bookService")
	private BookService service;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId,String inputBookTitle){
		Book book = new Book();
		book.setCn_user_id(userId);
		book.setCn_notebook_id(NoteUtil.createId());
		book.setCn_notebook_type_id("5");
		book.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
		book.setCn_notebook_name(inputBookTitle);
		NoteResult<Object> result = service.addBook(book);
		return result;
		
	}
}
