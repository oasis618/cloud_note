package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class ReplayNoteController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/replay.do")
	@ResponseBody
	public NoteResult execute(String rollbackId,String bookId){
		NoteResult result = new NoteResult();
		result = service.replayNote(rollbackId,bookId);
		return result;
	}
	
}
