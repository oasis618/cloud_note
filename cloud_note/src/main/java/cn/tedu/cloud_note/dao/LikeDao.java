package cn.tedu.cloud_note.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.Like;
@Repository("likeDao")
public interface LikeDao {
	int save(Like like);
	List<Like> findAll(String userId);
}
