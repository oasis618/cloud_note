package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.User;
import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult<User> login(String name,String password){
		NoteResult<User> result = userService.checkLogin(name, password);
		return result;
	}

}
