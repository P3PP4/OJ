import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, M;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());	// 정점 수
		M = Integer.parseInt(st.nextToken());	// 명령 수
		
		make();
		
		for (int i = 0; i < M; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(order == 1) {
				
				if(find(a) == find(b)) sb.append("YES").append("\n");
				else sb.append("NO").append("\n");
				
			} else union(a, b);
			
		}
		
		System.out.println(sb);
		
	}
	
	static void union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a == b) return;
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
		
	}
	
	static int find(int a) {
		
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
		
	}
	
	static void make() {
		
		parent = new int[N + 1];
		
		for (int i = 0; i <= N; i++) {
			
			parent[i] = i;
			
		}
		
	}
	
}