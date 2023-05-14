import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int scenario = 0;
		int N;
		String[] names;
		int[] cnt;
		while ((N = Integer.parseInt(br.readLine())) != 0) {
			names = new String[N + 1];
			cnt = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				names[i] = br.readLine();
			}
			for (int i = 1; i < N * 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				cnt[Integer.parseInt(st.nextToken())]++;
			}
			for (int i = 1; i <= N; i++) {
				if (cnt[i] == 1) {
					sb.append(++scenario).append(" ").append(names[i]).append("\n");
					break;
				}
			}
		}
		
		System.out.print(sb);
	
	}
	
}