package cn.tedu.cloud_note.entity;

import java.io.Serializable;
import java.util.List;
/*
 *	成员变量名同数据库字段名一样
 */
public class User implements Serializable{
	private String cn_user_id;
	private String cn_user_name;
	private String cn_user_password;
	private String cn_user_nick;
	
	private List<Book> books;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	@Override
	public String toString() {
		return "User [cn_user_id=" + cn_user_id + ", cn_user_name=" + cn_user_name + ", cn_user_password="
				+ cn_user_password + ", cn_user_nick=" + cn_user_nick + "]";
	}
	public String getCn_user_id() {
		return cn_user_id;
	}
	public void setCn_user_id(String cn_user_id) {
		this.cn_user_id = cn_user_id;
	}
	public String getCn_user_name() {
		return cn_user_name;
	}
	public void setCn_user_name(String cn_user_name) {
		this.cn_user_name = cn_user_name;
	}
	public String getCn_user_password() {
		return cn_user_password;
	}
	public void setCn_user_password(String cn_user_password) {
		this.cn_user_password = cn_user_password;
	}
	public String getCn_user_nick() {
		return cn_user_nick;
	}
	public void setCn_user_nick(String cn_user_nick) {
		this.cn_user_nick = cn_user_nick;
	}
	
}
