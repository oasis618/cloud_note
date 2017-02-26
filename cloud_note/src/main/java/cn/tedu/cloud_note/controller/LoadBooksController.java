package cn.tedu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.service.BookService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Resource(name="bookService")
	private BookService bookService;
	@RequestMapping("/loadBook.do")
	@ResponseBody
	public NoteResult<List<Book>> loadBook(String userId){
		NoteResult<List<Book>> result = bookService.loadUserBooks(userId);
		return result; 
	}
}
