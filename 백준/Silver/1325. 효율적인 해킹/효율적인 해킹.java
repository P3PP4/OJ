import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int maxCnt;
	static int[] cnt;
	static boolean[] visited;
	static ArrayList<Integer>[] list;
	
	public static void main(String[] args) throws Exception {
		
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		cnt = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			list[to].add(from);
		}
		
		for (int i = 1; i <= N; i++) {
			
			visited = new boolean[N + 1];
			dfs(i);
				
		}
		
		for (int i = 1; i <= N; i++) {
			
			if(cnt[i] > maxCnt) maxCnt = cnt[i];
			
		}
		
		for (int i = 1; i <= N; i++) {
			
			if(cnt[i] == maxCnt) sb.append(i + " ");
			
		}

		System.out.println(sb.toString());
		
	}
	
	static void dfs(int index) {
		
		visited[index] = true;
		
		for (int next : list[index]) {
			
			if(!visited[next]) {
				
				cnt[next]++;
				dfs(next);
				
			}
				
		}
		
	}
	
}