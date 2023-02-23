import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int cnt, temp;
	static boolean flag;
	static int[] target, check;
	
	public static void main(String[] args) throws Exception {
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			target = new int[N + 1];
			check = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				target[i] = Integer.parseInt(st.nextToken());
			}
			
			cnt = 0;
			
			for (int i = 1; i <= N; i++) {
				if (check[i] == 0) {
					flag = false;
					temp = 0;
					dfs(i, i);
				}
			}
			
			sb.append(N - cnt + "\n");
			
		}
		
		System.out.print(sb);
	
	}
	
	static void dfs(int start, int now) {
		
		check[now] = 2;
		
		if (target[now] == now) cnt++;
		else if (target[now] == start) flag = true;
		else if (check[target[now]] == 2) {
			temp = target[now];
			flag = true;
		} else if (check[target[now]] == 0) dfs(start, target[now]);
		
		if (flag) cnt++;
		if (temp != 0 && now == temp) flag = false;
		
		check[now] = 1;
		
	}
	
}