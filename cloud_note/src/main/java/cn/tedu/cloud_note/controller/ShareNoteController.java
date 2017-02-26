package cn.tedu.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.service.ShareService;
import cn.tedu.cloud_note.util.NoteResult;
import cn.tedu.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/share")
public class ShareNoteController {
	@Resource(name="shareService")
	private ShareService service;
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String noteId,String noteTitle,String noteBody){
		Share share = new Share();
		share.setCn_share_id(NoteUtil.createId());
		share.setCn_note_id(noteId);
		share.setCn_share_title(noteTitle);
		share.setCn_share_body(noteBody);
		
		NoteResult result = service.save(share);
		return result;
	}
	@RequestMapping("/load.do")
	@ResponseBody
	public NoteResult<Share> execute1(String shareId){
		NoteResult<Share> result = service.loadShare(shareId);
		System.out.println(shareId);
		return result;
	}
}
