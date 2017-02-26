package cn.tedu.cloud_note.service;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;

public interface UserService {
	public NoteResult<User> checkLogin(String name,String password);
	public NoteResult<Object> addUser(String name,String nickname,String password);
	public NoteResult<Object> checkPassword(String userId,String lastPwd);
	public NoteResult<Object> changePassword(String userId,String newPwd);
}
