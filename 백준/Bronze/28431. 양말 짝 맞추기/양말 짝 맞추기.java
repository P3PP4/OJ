import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] arr = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 != 0) System.out.print(i);
		}
		
	}
	
}