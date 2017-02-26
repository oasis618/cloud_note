package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.ShareDao;
import cn.tedu.cloud_note.entity.Share;

public class TestShareDao {
	ShareDao dao=null;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("shareDao",ShareDao.class);
	}
	@Test
	//save(Share)
	public void test1(){
		Share share = new Share();
		share.setCn_share_id("cn_share_id1111111111");
		share.setCn_share_title("cn_share_title111111");
		share.setCn_share_body("cn_share_body11111");
		share.setCn_note_id("cn_note_id111111");
		int i = dao.saveShare(share);
		System.out.println(i);
	}
	@Test
	public void test2(){
		String keys = "%1%";
		int page =1;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("title", keys);
		map.put("begin", page);
		List<Share> ss = dao.search(map);
		for (Share sss : ss) {
			System.out.println(sss);
			
		}

	}
	@Test
	public void test3(){
		Share sh = dao.loadShare("186a5ab3-5be7-4fb1-8378-3432cf774edb");
		System.out.println(sh);
	}
}
