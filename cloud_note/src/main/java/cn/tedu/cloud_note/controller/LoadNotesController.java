package cn.tedu.cloud_note.controller;

import java.util.List;

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
public class LoadNotesController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/loadNotes.do")
	@ResponseBody
	public NoteResult<List<Note>> loadNotes(String bookId){
		NoteResult<List<Note>> result = service.loadBookNotes(bookId);
		return result;
	}
	
}
