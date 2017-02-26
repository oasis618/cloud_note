package cn.tedu.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.UserDao;
import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	public NoteResult<User> checkLogin(String name, String password) {
		NoteResult<User> result = new NoteResult<User>();
		User user = userDao.findByName(name);
		if (user == null) {
			result.setStatus(1);
			result.setMsg("无此用户名");
			return result;
		}
		//检测密码
		String md5Password = NoteUtil.md5(password);
		if (!user.getCn_user_password().equals(md5Password)) {
			result.setStatus(2);
			result.setMsg("密码有误");
			return result;
		}
		result.setData(user);
		result.setMsg("登录成功");
		result.setStatus(0);
		return result;
	}
	public NoteResult<Object> addUser(String name,String nickname,String password) {
		NoteResult<Object> result = new NoteResult<Object>();
		//检测用户名
		User hasUser = userDao.findByName(name);
		if (hasUser != null) {
			result.setMsg("用户名已被注册");
			result.setStatus(1);
			return result;
		}
		//添加用户
		User user = new User();
		user.setCn_user_id(NoteUtil.createId());
		user.setCn_user_name(name);
		user.setCn_user_nick(nickname);
		user.setCn_user_password(NoteUtil.md5(password));
		userDao.save(user);
		result.setMsg("注册成功");
		result.setStatus(0);
		return result;
	}
	public NoteResult<Object> checkPassword(String userId,String lastPwd) {
		NoteResult<Object> result = new NoteResult<Object>();
		User user = userDao.checkPassword(userId);
		String cLastPwd = NoteUtil.md5(lastPwd);
		if (user.getCn_user_password().equals(cLastPwd)) {
			result.setStatus(0);
			result.setMsg("原密码正确");
		}else{
			result.setStatus(1);
			result.setMsg("原密码错误");
		}
		return result;
	}
	public NoteResult<Object> changePassword(String userId, String newPwd) {
		NoteResult<Object> result = new NoteResult<Object>();
		User user= new User();
		user.setCn_user_id(userId);
		user.setCn_user_password(NoteUtil.md5(newPwd));
		int i = userDao.changePassword(user);
		if (i==1) {
			result.setStatus(0);
			result.setMsg("密码修改成功");
		}else{
			result.setStatus(1);
			result.setMsg("密码修改失败");
		}
		return result;
	}
	

}
