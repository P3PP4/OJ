import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, result;
	static ArrayList<Node>[] list;
	static boolean[] visited, isParent;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		N = Integer.parseInt(br.readLine());	// 정점 수
		M = N - 1;								// 간선 수
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];			// 방문 체크
		isParent = new boolean[N + 1];			// 자식이 있는지?
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
			list[to].add(new Node(from, weight));
			isParent[from] = true;	// 자식노드가 있다면 true
		} // 입력 끝
		
		for (int i = 1; i <= N; i++) {
			
			// 자식이 없다면(단말 노드라면)
			if(!isParent[i]) {
				
				visited[i] = true;
				deep(i, 0);
				visited[i] = false;
				
			}
			
		}
		
		System.out.println(result);
		
	}
	
	static void deep(int now, int sum) {
		
		if(sum > result) result = sum;
		
		// 연결된 부모나 자식을 확인
		for (Node n : list[now]) {
			
			// 방문하지 않았다면
			if(!visited[n.to]) {
				
				visited[n.to] = true;
				deep(n.to, sum + n.weight);
				visited[n.to] = false;
				
			}
			
		}
		
	}
	
	static class Node {
		
		int to, weight;

		public Node(int to, int weight) {

			this.to = to;
			this.weight = weight;
			
		}
		
	}
	
}