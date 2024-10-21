import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, A, B;
	static int[] min;
	static boolean[] check;
	static List<Node>[] list;
	static StringTokenizer st;
	static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		min = new int[N + 1];
		check = new boolean[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			min[i] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}
		st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		pq.offer(new Node(A, 0));
		min[A] = 0;
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (!check[now.to]) {
				check[now.to] = true;
				for (Node next : list[now.to]) {
					if (!check[next.to] && min[next.to] > min[now.to] + next.weight) {
						min[next.to] = min[now.to] + next.weight;
						pq.add(new Node(next.to, min[next.to]));
					}
				}
			}
		}
		
		System.out.print(min[B]);
	
	}
	
	static class Node {
		int to, weight;
		
		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
}