import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] dist = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			dist[i] = Math.abs(cur - S);
		}
		
		int max = dist[0];
		
		for (int i = 1; i < N; i++) {
			max = euclidean(max, dist[i]);
		}
		
		System.out.print(max);
	
	}
	
	static int euclidean(int a, int b) {
		if (b == 0) return a;
		return euclidean(b, a % b);
	}
	
}