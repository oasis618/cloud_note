package single;

public class Singleton2 {
	private static final Singleton2 single = new Singleton2();
	public static Singleton2 getInstance(){
		return single;
	}
	Singleton2(){
		System.out.println("singleton2+execute");
	}
}
