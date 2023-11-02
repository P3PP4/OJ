import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int min = 999;
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				int n = Integer.parseInt(st.nextToken());
				if (n % 2 == 0) {
					sum += n;
					if (min > n) min = n;
				}
			}
			sb.append(sum).append(" ").append(min).append("\n");
		}
		System.out.print(sb);
	
	}
	
}