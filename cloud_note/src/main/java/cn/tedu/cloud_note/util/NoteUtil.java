package cn.tedu.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;

public class NoteUtil {
	/**
	 * 利用UUID算法生成主键
	 * @return
	 */
	public static String createId(){
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		return id.replace("-", "");
	}
	
	/**
	 * MD5加密处理工具
	 * @param src
	 * @return
	 */
	public static String md5(String src){
		MessageDigest md = null;
		byte[] output = null;
		try {
			//MD5加密处理
			md = MessageDigest.getInstance("MD5");
			//Base64处理输出字符有a-z A-Z 0-9组成
			output = md.digest(src.getBytes());
			String ret = Base64.encodeBase64String(output);
			return new String(ret);
		} catch (Exception e) {
			throw new NoteException("加密失败",e);
		}
	}
}
