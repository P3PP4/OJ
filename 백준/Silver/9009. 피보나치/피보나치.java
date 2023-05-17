import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] fibo = new int[45];
		fibo[1] = 1;
		for (int i = 2; i < 45; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringBuilder temp = new StringBuilder();
			int N = Integer.parseInt(br.readLine());
			int i = 44;
			while (0 < N) {
				if (fibo[i] <= N) {
					N -= fibo[i];
					temp.insert(0, fibo[i] + " ");
				}
				i--;
			}
			sb.append(temp).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}