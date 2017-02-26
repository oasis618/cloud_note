package cn.tedu.cloud_note.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.tedu.cloud_note.entity.Share;
@Repository("shareDao")
public interface ShareDao {
	int saveShare(Share share);
	List<Share> search(Map<String,Object> map);
	Share loadShare(String shareId);
}
