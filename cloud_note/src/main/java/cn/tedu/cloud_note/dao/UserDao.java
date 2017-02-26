package cn.tedu.cloud_note.dao;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.User;

@Repository("userDao")
public interface UserDao {
	public User findByName(String name);
	void save(User user);
	User checkPassword(String userId);
	int changePassword(User user);
}
