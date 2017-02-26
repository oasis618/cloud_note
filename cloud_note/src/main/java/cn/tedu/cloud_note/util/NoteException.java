package cn.tedu.cloud_note.util;

public class NoteException extends RuntimeException{

	public NoteException() {
		super();
	}

	public NoteException(String message) {
		super(message);
	}

	public NoteException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
