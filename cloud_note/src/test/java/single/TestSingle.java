package single;

public class TestSingle {
	public static void main(String[] args) {
		Singleton.getInstance();
		Singleton2.getInstance();
		int [][] arr = new int[10][];
		for (int i = 0; i < 10; i++) {
			arr[i] = new int [i+1];
			for (int j = 0; j < arr[i].length; j++) {
				if (i==0||j==0||j==arr[i].length-1) {
					arr[i][j]=1;
				}else{
					arr[i][j]=arr[i-1][j-1]+arr[i-1][j];
				}
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
