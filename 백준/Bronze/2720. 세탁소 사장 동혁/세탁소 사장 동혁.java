import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int[] unit = { 25, 10, 5, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int C = Integer.parseInt(br.readLine());
			int[] cnt = new int[4];
			for (int i = 0; i < 4; i++) {
				if (0 < C / unit[i]) {
					cnt[i] = C / unit[i];
					C %= unit[i];
				}
				sb.append(cnt[i]).append(" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	
	}
	
}