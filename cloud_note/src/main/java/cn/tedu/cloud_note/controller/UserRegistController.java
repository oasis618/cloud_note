package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> add(String nickname,String name,String password){
		NoteResult<Object> result = userService.addUser(name,nickname,password);
		return result;
	}
}
