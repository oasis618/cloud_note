package test.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.cloud_note.dao.NoteDao;
import cn.tedu.cloud_note.entity.Note;

public class TestNoteDao {
	NoteDao dao=null;
	@Before
	public void init(){
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac = new ClassPathXmlApplicationContext(conf);
		dao = ac.getBean("noteDao",NoteDao.class);
	}
	/**
	 * 测试BookDao findByBookId方法
	 */
	@Test
	public void test1(){
		List<Note> u = dao.findByBookId("4b86d1f9-6345-4532-bc50-ee86442f004b");
		for (Note book : u) {
			System.out.println(book);
		}
	}
	/**
	 * 测试BookDao findByNoteId方法
	 */
	@Test
	public void test2(){
		Note u = dao.findByNoteId("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(u);
	}
	/**
	 * 测试BookDao updateNote方法
	 */
	@Test
	public void test3(){
		Note note = new Note();
		note.setCn_note_id("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		note.setCn_note_title("修改后的标题1133");
		note.setCn_note_body("修改后的body1133");
		note.setCn_note_last_modify_time(new Date().getTime());
		/*HashMap map = new HashMap();
		map.put("noteId", note.getCn_note_id());
		map.put("noteTitle", note.getCn_note_title());
		map.put("noteBody", note.getCn_note_body());*/
		int i = dao.updateNote(note);
		System.out.println(i);
	}
	/**
	 * 测试save(note)方法
	 */
	@Test
	public void test4(){
		Note note = new Note();
		note.setCn_note_id("noteid666666");
		note.setCn_notebook_id("cn_notebook_id666666");
		note.setCn_user_id("cn_user_id6666666666");
		long now = new Date().getTime();
		note.setCn_note_create_time(now);
		note.setCn_note_last_modify_time(now);
		int i = dao.saveNote(note);
		if (i==1) {
			System.out.println("ok");
		}else{
			System.out.println("error");
		}
	}
	/**
	 * 测试delete(noteId)
	 */
	@Test
	public void test5(){
		String noteId = "003ec2a1-f975-4322-8e4d-dfd206d6ac0c";
		int i = dao.deleteNote(noteId);
		System.out.println(i);
	}
	/**
	 * 测试findByUserId
	 */
	 @Test
	 public void test6(){
		 List<Note> notes = dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		 for (Note note : notes) {
			System.out.println(note);
		}
	 }
	 /**
	  * 测试动态SQL
	  */
	 @Test
	 public void test7(){
		 Map<String,Object> map = new HashMap<String,Object>();
		 map.put("title", "java");
		 map.put("noteId", "046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		 dao.updateNoteByMap(map);
	 }
	 /**
	  * 测试删除多条数据
	  */
	 @Test
	 public void test8(){
		 Map<String,Object> map=new HashMap<String,Object>();
		 String [] ids ={"id1","id2","id3"};
		 map.put("ids", ids);
		 map.put("status", 1);
		 
		 int n = dao.deleteNotes(map);
		 System.out.println(n);
	 }
	 
}
















