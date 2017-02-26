package cn.tedu.cloud_note.dao;

import java.util.List;

import cn.tedu.cloud_note.entity.Book;
import cn.tedu.cloud_note.entity.User;

public interface RelationDao {
	//关联多个对象
	User findUserAndBooks(String userId);
	User findUserAndBooks1(String userId);
	
	//关联单个对象
	List<Book> findBookAndUser();
	List<Book> findBookAndUser1();
}
