package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.entity.Share;
import cn.tedu.cloud_note.service.ShareService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestShareService extends TestBase{
	ShareService service;
	@Before
	public void init(){
		 service = getContext().getBean("shareService",ShareService.class);
	}
	
	@Test
	public void test1(){
		Share share = new Share();
		share.setCn_share_id("cn_share_id11111111112");
		share.setCn_share_title("cn_share_title1111112");
		share.setCn_share_body("cn_share_body111112");
		share.setCn_note_id("cn_note_id1111112");
		NoteResult nra = service.save(share);
		System.out.println(nra.getMsg());
	}
	@Test
	public void test2(){
		NoteResult<List<Share>> result = service.searchByKey("1",1);
		System.out.println(result.getData());
	}
	@Test
	public void test3(){
		NoteResult<Share> result = service.loadShare("186a5ab3-5be7-4fb1-8378-3432cf774edb");
		System.out.println(result.getData());
	}
}
