import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int start = N - (N % 100);
		for (int i = start; i < start + 100; i++) {
			if (i % K == 0) {
				int mod = i % 100;
				if (i % 100 < 10) System.out.print("0" + mod);
				else System.out.print(mod);
				return;
			}
		}
	
	}
	
}