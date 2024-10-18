import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int weight = 500;
	static int N, K, ans;
	static int[] add;
	static boolean[] used;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		add = new int[N];
		used = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			add[i] = Integer.parseInt(st.nextToken());
		}
		
		find(0);
		
		System.out.print(ans);
	
	}
	
	static void find(int cnt) {
		if (weight < 500) return;
		
		if (cnt == N) {
			ans++;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!used[i]) {
				used[i] = true;
				weight += add[i] - K;
				find(cnt + 1);
				used[i] = false;
				weight -= add[i] - K;
			}
		}
	}
	
}