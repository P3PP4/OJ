import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[21];
		arr[1] = 1;
		for (int i = 2; i < 21; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		System.out.print(arr[N]);
		
	}
	
}