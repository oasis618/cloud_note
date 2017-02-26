package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.util.NoteResult;

public interface BookService {
	NoteResult<List<Book>> loadUserBooks(String userId);
	NoteResult addBook(Book book);
}
