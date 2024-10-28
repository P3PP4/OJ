import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				sb.append(" ");
			}
			for (int j = 0; j <= i; j++) {
				sb.append("* ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
}