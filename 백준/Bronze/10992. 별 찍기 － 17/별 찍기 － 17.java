import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			for (int j = i; j < N; j++) {
				sb.append(" ");
			}
			if (i != 1) sb.append("*");
			for (int j = 0; j < (i - 1) * 2 - 1; j++) {
				sb.append(" ");
			}
			sb.append("*\n");
		}
		for (int i = 0; i < N * 2 - 1; i++) {
			sb.append("*");
		}
		
		System.out.print(sb);
	
	}
	
}