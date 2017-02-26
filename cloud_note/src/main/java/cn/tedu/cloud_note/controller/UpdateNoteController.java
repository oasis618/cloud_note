package cn.tedu.cloud_note.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/updateNote.do")
	@ResponseBody
	public NoteResult<Integer> update(String mNoteId,String mTitle,String mBody){
		Note note = new Note();
		note.setCn_note_id(mNoteId);
		note.setCn_note_title(mTitle);
		note.setCn_note_body(mBody);
		note.setCn_note_last_modify_time(new Date().getTime());
		NoteResult<Integer> result = service.updateBook(note);
		return result;
	}
}
