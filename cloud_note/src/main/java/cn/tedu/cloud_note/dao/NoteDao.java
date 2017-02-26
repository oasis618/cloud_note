package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.Note;

@Repository("noteDao")
public interface NoteDao {
	List<Note> findByBookId(String bookId);
	Note findByNoteId(String noteId);
	int updateNote(Note note);
	int saveNote(Note note);
	int deleteNote(String noteId);
	//回收站笔记
	List<Note> findByUserId(String userId);
	Note loadRollbackNote(String rollbackId);
	int aDeleteNote(String noteId);
	int replayNote(Note note);
	int moveNote(Note note);
	//动态SQL
	void updateNoteByMap(Map<String,Object> map);
	//批量删除
	/**
	 * map中需要添加的两个参数:
	 * 	map={ids:[id1,id2,id3...],status:1}
	 * ids 代表被删除笔记的ID列表
	 * status 代表被删除笔记的状态属性
	 * @param map
	 * @return
	 */
	int deleteNotes(Map<String,Object>map);
	
	int deleteNoteById(String id);
}
