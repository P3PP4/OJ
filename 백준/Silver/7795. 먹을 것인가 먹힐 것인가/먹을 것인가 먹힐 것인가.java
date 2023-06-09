import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arrN[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arrN);
			Arrays.sort(arrM);
			
			int indexN = 0;
			int indexM = 0;
			int cnt = 0;
			while (indexN < N) {
				if (arrN[indexN] <= arrM[indexM]) {
					if (++indexN != N) cnt += indexM;
				}
				else {
					cnt++;
					if (++indexM == M) {
						cnt += (N - indexN - 1) * M;
						break;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}