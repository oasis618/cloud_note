package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.UserService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/change")
public class ChangePwdController {
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("/check.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId,String lastPwd){
		NoteResult<Object> result = userService.checkPassword(userId, lastPwd);
		return result;
	}
	@RequestMapping("/password.do")
	@ResponseBody
	public NoteResult<Object> execute1(String userId,String newPwd){
		NoteResult<Object> result = userService.changePassword(userId, newPwd);
		return result;
	}	
}
