package cn.tedu.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.util.NoteResult;
@Service("shareService")
@Transactional
public class ShareServiceImpl implements ShareService {
	@Resource(name="shareDao")
	private ShareDao dao;
	public NoteResult save(Share share) {
		NoteResult result = new NoteResult();
		int i = dao.saveShare(share);
		/*
		 * 测试AOP输出异常内容
		 * String str = null;
		 *str.length();
		 */
		if (i==1) {
			result.setStatus(0);
			result.setMsg("笔记分享成功");
		}else{
			result.setStatus(1);
			result.setMsg("笔记分享失败");
		}
		return result;
	}
	public NoteResult<List<Share>> searchByKey(String key,int page) {
		NoteResult<List<Share>> result = new NoteResult<List<Share>>();
		String keyword = "%"+key+"%";
		int begin = (page-1)*5;//计算起点
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("title", keyword);
		params.put("begin", begin);
		List<Share> shares = dao.search(params);
		if(shares.size()>0){
			result.setData(shares);
			result.setMsg("搜索成功!");
			result.setStatus(0);
		}else{
			result.setMsg("搜索失败!");
			result.setStatus(1);
		}
		
		return result;
	}
	public NoteResult<Share> loadShare(String shareId) {
		NoteResult<Share> result = new NoteResult<Share>();
		Share share = dao.loadShare(shareId);
		if (share!=null) {
			result.setStatus(0);
			result.setMsg("加载分享笔记成功");
			result.setData(share);
		}else{
			result.setStatus(1);
			result.setMsg("加载分享笔记失败");
		}
		return result;
	}
	
	

}
