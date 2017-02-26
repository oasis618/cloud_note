package test.service;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.cloud_note.entity.Note;
import cn.tedu.cloud_note.service.NoteService;
import cn.tedu.cloud_note.util.NoteResult;

public class TestNoteService extends TestBase{
	NoteService service = null;
	@Before
	public void init(){
		 service = getContext().getBean("noteService",NoteService.class);
	}
	
	@Test
	public void test(){
		NoteResult<List<Note>> rs = service.loadBookNotes("4b86d1f9-6345-4532-bc50-ee86442f004b");
		System.out.println(rs.getData());
	}
	@Test
	public void test1(){
		NoteResult<Note> rs = service.loadNoteBook("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(rs.getMsg());
	}
	
	@Test
	public void test2(){
		Note note = new Note();
		note.setCn_note_id("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		note.setCn_note_title("修改后的标题service");
		note.setCn_note_body("修改后的bodyservice");
		NoteResult<Integer> rs = service.updateBook(note);
		System.out.println(rs.getMsg());
	}
	@Test
	public void test3(){
		Note note = new Note();
		note.setCn_note_id("noteid66666611");
		note.setCn_notebook_id("cn_notebook_id66666611");
		note.setCn_user_id("cn_user_id666666666611");
		long now = new Date().getTime();
		note.setCn_note_create_time(now);
		note.setCn_note_last_modify_time(now);
		NoteResult result = service.saveNote(note);
		System.out.println(result.getMsg());
	}
	@Test
	public void test4(){
		NoteResult re = service.deleteNote("019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0");
		System.out.println(re.getMsg());
	}
	@Test
	public void test5(){
		NoteResult re = service.aDeleteNote("01da5d69-89d5-4140-9585-b559a97f9cb0");
		System.out.println(re.getMsg());
	}
	@Test
	public void test6(){
		NoteResult re = service.replayNote("3278c5e55939415f87a6bd33b87ef7a9","");
		System.out.println(re.getMsg());
	}
	@Test
	public void test7(){
		NoteResult re = service.moveNote("0037215c-09fe-4eaa-aeb5-25a340c6b39b", "046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		System.out.println(re.getMsg());
	}
	@Test
	public void test8(){
		//String[] ids= {"id1","id2"};
		service.deleteNoteById("046b0110-67f9-48c3-bef3-b0b23bda9d4e","id2","id3");
	}
}




