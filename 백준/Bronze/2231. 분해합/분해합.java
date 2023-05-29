import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			int sum = i;
			int num = i;
            
			while (0 < num) {
				sum += num % 10;
				num /= 10;
			}
            
			if (sum == N) {
				System.out.print(i);
				return;
			}
		}
		
		System.out.print(0);
	
	}
	
}