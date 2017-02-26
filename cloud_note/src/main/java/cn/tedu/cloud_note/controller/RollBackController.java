package cn.tedu.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/rollback")
public class RollBackController {
	@Resource(name="noteService")
	private NoteService service;
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult<List<Note>> execute(String userId){
		NoteResult<List<Note>> result = new NoteResult<List<Note>>();
		result = service.loadRollBack(userId);
		return result;
	}
	@RequestMapping("/loadNote.do")
	@ResponseBody
	public NoteResult<Note> execute1(String rollbackId){
		NoteResult<Note> result = new NoteResult<Note>();
		result = service.loadRollbackNote(rollbackId);
		return result;
	}
		
}
