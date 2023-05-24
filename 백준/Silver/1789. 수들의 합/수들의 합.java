import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		int i;
		long sum = 0;
		for (i = 1; i < 100000; i++) {
			sum += i;
			if (S < sum) break;
		}
		
		System.out.print(i - 1);
	
	}
	
}