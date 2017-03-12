package single;

public class Singleton {
	private static Singleton singleton = null;
	public static synchronized Singleton getInstance(){
		if(singleton == null){
			singleton = new Singleton(); 
		}
		return singleton;
	}
	public Singleton() {
		System.out.println("singleton+execute");
	}
	public void write(String key){
		System.out.println(key);
	}
}
