package test.util;

import org.junit.Test;

import cn.tedu.cloud_note.util.NoteUtil;

public class Util {
	@Test
	public void test(){
		System.out.println(NoteUtil.md5(NoteUtil.createId()));
	}
}
