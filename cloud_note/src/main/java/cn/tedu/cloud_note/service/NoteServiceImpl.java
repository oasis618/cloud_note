package cn.tedu.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

@Service("noteService")
public class NoteServiceImpl implements NoteService{
	@Resource(name="noteDao")
	private NoteDao dao;
	public NoteResult<List<Note>> loadBookNotes(String bookId) {
		List<Note> notes = dao.findByBookId(bookId);
		NoteResult<List<Note>> result = new NoteResult<List<Note>>(); 
		if (notes.size()>0 && notes != null) {
			result.setStatus(0);
			result.setMsg("笔记加载成功");
			result.setData(notes);
		}else{
			result.setStatus(1);
			result.setMsg("笔记加载失败");
		}
		return result;
	}
	public NoteResult<Note> loadNoteBook(String noteId){
		Note note = dao.findByNoteId(noteId);
		NoteResult<Note> result = new NoteResult<Note>();
		if (note != null) {
			result.setData(note);
			result.setMsg("笔记内容加载成功");
			result.setStatus(0);
		}else{
			result.setStatus(1);
			result.setMsg("笔记内容加载失败");
		}
		return result;
	}
	public NoteResult<Integer> updateBook(Note note) {
		NoteResult<Integer> result = new NoteResult<Integer>();
		int i = dao.updateNote(note);
		if (i==1) {
			result.setMsg("保存笔记成功");
			result.setStatus(0);
		}else{
			result.setMsg("保存笔记失败");
			result.setStatus(1);
		}
		return result;
	}
	public NoteResult saveNote(Note note) {
		NoteResult result = new NoteResult();
		int i = dao.saveNote(note);
		if (i==1) {
			result.setMsg("创建笔记成功");
			result.setStatus(0);
		}else{
			result.setMsg("创建笔记失败");
			result.setStatus(1);
		}
		return result;
	}
	public NoteResult deleteNote(String noteId) {
		NoteResult result = new NoteResult();
		int i = dao.deleteNote(noteId);
		if (i==1) {
			result.setMsg("笔记删除成功");
			result.setStatus(0);
		}else{
			result.setMsg("笔记删除失败");
			result.setStatus(1);
		}
		return result;
	}
	public NoteResult<List<Note>> loadRollBack(String userId) {
		List<Note> notes = dao.findByUserId(userId);
		NoteResult<List<Note>> result = new NoteResult<List<Note>>(); 
		if (notes.size()>0 && notes != null) {
			result.setStatus(0);
			result.setMsg("回收站笔记加载成功");
			result.setData(notes);
		}else{
			result.setStatus(1);
			result.setMsg("回收站笔记加载失败");
		}
		return result;
	}
	public NoteResult<Note> loadRollbackNote(String rollbackId) {
		Note note = dao.loadRollbackNote(rollbackId);
		NoteResult<Note> result = new NoteResult<Note>();
		if (note != null) {
			result.setData(note);
			result.setMsg("回收站笔记内容加载成功");
			result.setStatus(0);
		}else{
			result.setStatus(1);
			result.setMsg("回收站笔记内容加载失败");
		}
		return result;
	}
	public NoteResult aDeleteNote(String noteId) {
		NoteResult result = new NoteResult();
		int i = dao.aDeleteNote(noteId);
		if (i==1) {
			result.setMsg("笔记彻底删除成功");
			result.setStatus(0);
		}else{
			result.setMsg("笔记彻底删除失败");
			result.setStatus(1);
		}
		return result;
	}
	public NoteResult replayNote(String noteId,String bookId) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		System.out.println(note);
		int i = dao.replayNote(note);
		if (i==1) {
			result.setMsg("笔记恢复成功");
			result.setStatus(0);
		}else{
			result.setMsg("笔记恢复失败");
			result.setStatus(1);
		}
		return result;
	}
	public NoteResult<Object> moveNote(String bookId, String noteId) {
		Note note = new Note();
		note.setCn_notebook_id(bookId);
		note.setCn_note_id(noteId);
		NoteResult<Object> result = new NoteResult<Object>();
		int i = dao.moveNote(note);
		if (i==1) {
			result.setMsg("笔记移动成功");
			result.setStatus(0);
		}else{
			result.setMsg("笔记移动失败");
			result.setStatus(1);
		}
		return result;
	}
	@Transactional
	public void deleteNoteById(String... noteIds) {
		for (String id : noteIds) {
			int n = dao.deleteNoteById(id);
			System.out.println(n);
			if (n!=1) {
				//抛出异常触发事物的回滚
				throw new RuntimeException("error");
			}
		} 
	}

}
