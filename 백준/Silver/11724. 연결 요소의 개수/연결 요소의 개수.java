import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] parent;
	static int N, M, cnt;
	
	public static void main(String[] args) throws IOException {
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		make();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(union(a, b)) {
				if(++cnt == N - 1) {
					System.out.println(1);
					return;
				}
			}
		}
		HashSet<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
		
	}
	
	static boolean union(int a, int b) {
		
		a = find(a);
		b = find(b);
		
		if(a == b) return false;
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
		return true;
		
	}
	
	static int find(int a) {
		
		if(parent[a] == a) return a;
		
		return parent[a] = find(parent[a]);
		
	}
	
	static void make() {
		
		parent = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			
			parent[i] = i;
			
		}
		
	}
	
}