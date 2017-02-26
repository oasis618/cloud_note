package cn.tedu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Like;
import cn.tedu.cloud_note.service.LikeService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@RequestMapping("/like")
@Controller
public class LikeNoteController {
	@Resource(name="likeService")
	private LikeService service;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String noteId,String userId,String title,String body){
		Like like = new Like();
		like.setCn_user_id(userId);
		like.setCn_note_id(noteId);
		like.setCn_like_title(title);
		like.setCn_like_body(body);
		like.setCn_like_id(NoteUtil.createId());
		NoteResult<Object> result = service.save(like);
		return result;
	}
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult<List<Like>> execute1(String userId){
		NoteResult<List<Like>> result = service.findAll(userId);
		List<Like> ls = result.getData();
		for (Like like : ls) {
			System.out.println(like);
		}
		
		return result;
	}
	
}
