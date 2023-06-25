import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] input = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(input, (o1, o2) -> o2[2] - o1[2]);
		int[] cnt = new int[N];
		int brk = 0;
		for (int i = 0; i < N; i++) {
			if (cnt[input[i][0]] < 2) {
				sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
				cnt[input[i][0]]++;
				if (++brk == 3) break;
			}
		}
		System.out.print(sb);
	
	}
	
}