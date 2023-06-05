import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0) break;
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			for (int i = 0; i < N; i++) {
				arrN[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < M; i++) {
				arrM[i] = Integer.parseInt(br.readLine());
			}
			
			int ni = 0;
			int mi = 0;
			int cnt = 0;
			while (ni < N && mi < M) {
				if (arrN[ni] == arrM[mi]) {
					cnt++;
					ni++;
					mi++;
				}
				else if (arrN[ni] < arrM[mi]) ni++;
				else mi++;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}