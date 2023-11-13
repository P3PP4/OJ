import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] input = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			int idx  = N - 1;
			int next = N - 2;
			long sum = 0;
			while (0 < idx) {
				int n = input[idx];
				for (next = idx - 1; next >= 0; next--) {
					if (n < input[next]) {
						idx = next;
						break;
					}
					else {
						sum += n - input[next];
					}
				}
				if (next < 0) break;
			}
			sb.append(sum).append("\n");
		}
		System.out.print(sb);
	
	}
	
}