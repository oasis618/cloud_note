package cn.tedu.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.cloud_note.dao.LikeDao;
import cn.tedu.cloud_note.entity.Like;
import cn.tedu.cloud_note.util.NoteResult;
@Service("likeService")
public class LikeServiceImpl implements LikeService {
	@Resource(name="likeDao")
	private LikeDao dao;
	public NoteResult<Object> save(Like like) {
		NoteResult<Object> result = new NoteResult<Object>();
		int i = dao.save(like);
		if (i==1) {
			result.setStatus(0);
			result.setMsg("笔记收藏成功");
		}else{
			result.setStatus(1);
			result.setMsg("笔记收藏失败");
		}
		return result;
	}
	public NoteResult<List<Like>> findAll(String userId) {
		NoteResult<List<Like>> result = new NoteResult<List<Like>>();
		List<Like> likes = dao.findAll(userId);
		if (likes!=null && likes.size()>0) {
			result.setStatus(0);
			result.setMsg("收藏笔记加载成功");
			result.setData(likes);
		}else{
			result.setStatus(1);
			result.setMsg("收藏笔记加载失败");
		}
		return result;
	}

}
