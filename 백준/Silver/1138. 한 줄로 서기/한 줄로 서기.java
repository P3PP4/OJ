import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] info = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			info[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] order = new int[N + 1];
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (order[j] == 0) {
					if (info[i] == cnt) {
						order[j] = i + 1;
						break;
					}
					cnt++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			sb.append(order[i]).append(" ");
		}
		System.out.print(sb);
	
	}
	
}