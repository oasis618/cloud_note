package cn.tedu.cloud_note.controller;

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
public class LoadNoteBookController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/loadNoteBook.do")
	@ResponseBody
	public NoteResult<Note> loadNote(String noteId){
		NoteResult<Note> result = service.loadNoteBook(noteId);
		return result;
	}
	@RequestMapping("/loadRollbackNote.do")
	@ResponseBody
	public NoteResult<Note> loadRollbackNote(String rollbackId){
		NoteResult<Note> result = service.loadRollbackNote(rollbackId);
		return result;
	}
}
