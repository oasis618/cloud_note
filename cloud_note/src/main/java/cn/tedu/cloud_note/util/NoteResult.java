package cn.tedu.cloud_note.util;

import java.io.Serializable;

public class NoteResult<T> implements Serializable{
	private int status;
	private String msg;
	private T data;
	
	@Override
	public String toString() {
		return "NoteResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
