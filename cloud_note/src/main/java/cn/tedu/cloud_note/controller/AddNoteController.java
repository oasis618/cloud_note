package cn.tedu.cloud_note.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Object> execute(String userId,String noteTitle,String bookId){
		Note note = new Note();
		note.setCn_note_id(NoteUtil.createId());
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_title(noteTitle);
		long now = new Date().getTime();
		//long now = System.currentTimeMillis();
		note.setCn_note_create_time(now);
		note.setCn_note_last_modify_time(now);
		NoteResult<Object> result = service.saveNote(note);
		result.setData(note);
		return result;
		
	}
}
