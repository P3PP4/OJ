import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		for (int x = -2000; x <= 2000; x++) {
			int ans = x * x + (2 * A * x) + B;
			if (ans == 0) sb.append(x).append(" ");
		}
		
		System.out.print(sb);
	
	}
	
}