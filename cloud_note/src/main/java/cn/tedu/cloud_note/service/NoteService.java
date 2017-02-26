package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.util.NoteResult;

public interface NoteService {
	NoteResult<List<Note>> loadBookNotes(String bookId);
	NoteResult<Note> loadNoteBook(String noteId);
	NoteResult<Integer> updateBook(Note note);
	NoteResult<Object> saveNote(Note note);
	NoteResult<Object> deleteNote(String noteId);
	NoteResult<List<Note>> loadRollBack(String userId);
	NoteResult<Note> loadRollbackNote(String rollbackId);
	NoteResult<Object> aDeleteNote(String noteId);
	NoteResult<Object> replayNote(String noteId,String bookId);
	NoteResult<Object> moveNote(String bookId,String noteId);
	//测试AOP事物处理
	void deleteNoteById(String... noteId);
}
