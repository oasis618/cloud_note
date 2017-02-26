package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Like;
import cn.tedu.cloud_note.util.NoteResult;

public interface LikeService {
	NoteResult<Object> save(Like like);
	NoteResult<List<Like>> findAll(String userId);
}
