package cn.tedu.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.BookDao;
import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;
@Service("bookService")
public class BookServiceImpl implements BookService {
	@Resource(name="bookDao")
	private BookDao dao;
	public NoteResult<List<Book>> loadUserBooks(String userId) {
		List<Book> books = dao.findByUserId(userId);
		NoteResult<List<Book>> result = new NoteResult<List<Book>>();
		if (books.size()>0 && books !=null) {
			result.setStatus(0);
			result.setMsg("查询笔记本成功");
			result.setData(books);
			return result;
		}else{
			result.setStatus(1);
			
			return result;
		}
	}
	public NoteResult addBook(Book book) {
		NoteResult result = new NoteResult();
		int i = dao.save(book);
		if (i==1) {
			result.setStatus(0);
			result.setMsg("笔记本添加成功");
		}else{
			result.setStatus(1);
			result.setMsg("笔记本添加失败");
		}
		return result;
	}

}
