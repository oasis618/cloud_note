package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class MoveNoteController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/moveNote.do")
	@ResponseBody
	public NoteResult<Object> execute(String bookId,String noteId){
		System.out.println(bookId);
		System.out.println(noteId);
		NoteResult<Object> result = service.moveNote(bookId, noteId);
		return result;
		
	}
}
