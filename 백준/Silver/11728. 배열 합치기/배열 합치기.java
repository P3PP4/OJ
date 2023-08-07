import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int a = 0;
		int b = 0;
		while (true) {
			if (a == N) {
				if (b == M) break;
				sb.append(B[b++]);
			}
			else if (b == M) sb.append(A[a++]);
			else {
				if(A[a] < B[b]) sb.append(A[a++]);
				else sb.append(B[b++]);
			}
			sb.append(" ");
		}
		System.out.print(sb);
	
	}
	
}