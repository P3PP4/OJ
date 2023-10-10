import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, s, e, max;
	static boolean[] visited;
	static ArrayList<Path>[] list;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		visited = new boolean[N + 1];
		list = new ArrayList[N + 1];
		visited[s] = true;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Path(to, weight));
			list[to].add(new Path(from, weight));
		}
		
		find(s, 0, 0);
		
		System.out.print(max);
	
	}
	
	static void find(int idx, int sum, int maxWeight) {
		if (idx == e) {
			if (sum - maxWeight > max) max = sum - maxWeight;
			return;
		}
		
		for (Path next : list[idx]) {
			if (!visited[next.to]) {
				visited[next.to] = true;
				find(next.to, sum + next.weight, Math.max(maxWeight, next.weight));
				visited[next.to] = false;
			}
		}
	}
	
	static class Path {
		int to, weight;
		
		public Path(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
}