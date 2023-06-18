import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int[][] input = new int[2][6];
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				input[0][i] = input[1][i] = Integer.parseInt(st.nextToken());
				sum += input[0][i];
			}
			
			int day = 1;
			while (sum <= N) {
				sum = 0;
				int d = day % 2;
				int next = (day + 1) % 2;
				for (int i = 0; i < 6; i++) {
					input[next][i] = input[d][i] +
									input[d][i - 1 < 0 ? 5 : i - 1] +
									input[d][(i + 1) % 6] +
									input[d][(i + 3) % 6];
					sum += input[next][i];
				}
				
				day++;
			}
			
			sb.append(day).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}