package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/delete.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = service.deleteNote(noteId);
		return result;
	}
	@RequestMapping("/aDelete.do")
	@ResponseBody
	public NoteResult execute1(String rollbackId){
		NoteResult result = service.aDeleteNote(rollbackId);
		return result;
	}
}
