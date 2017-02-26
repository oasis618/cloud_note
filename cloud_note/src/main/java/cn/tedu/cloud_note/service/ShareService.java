package cn.tedu.cloud_note.service;

import java.util.List;

import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;

public interface ShareService {
	NoteResult save(Share share);
	NoteResult<List<Share>> searchByKey(String key,int page);
	NoteResult<Share> loadShare(String shareId);
}
