package cn.tedu.cloud_note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.Book;
@Repository("bookDao")
public interface BookDao {
	List<Book> findByUserId(String id);
	int save(Book book);
}
