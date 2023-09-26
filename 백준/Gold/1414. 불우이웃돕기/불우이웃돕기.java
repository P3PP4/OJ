import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int N, total, con = 1;
	static int[] parent;
	static PriorityQueue<Line> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		make();
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				if ('a' <= s.charAt(j)) {
					pq.add(new Line(i, j + 1, s.charAt(j) - 'a' + 1));
					total += s.charAt(j) - 'a' + 1;
				} else if ('A' <= s.charAt(j)) {
					pq.add(new Line(i, j + 1, s.charAt(j) - 'A' + 27));
					total += s.charAt(j) - 'A' + 27;
				}
			}
		}
		
		if (N == 1) {
			System.out.print(total);
			return;
		}
		
		while (!pq.isEmpty()) {
			Line l = pq.poll();
			if (union(l.from, l.to)) {
				total -= l.weight;
				if (++con == N) {
					System.out.print(total);
					return;
				}
			}
		}
		System.out.print(-1);
	
	}
	
	static void make() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int a) {
		if (a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) return false;
		if (a < b) parent[b] = a;
		else parent[a] = b;
		return true;
	}
	
	static class Line implements Comparable<Line> {
		int from, to, weight;
		
		public Line(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Line o) {
			return this.weight - o.weight;
		}
	}
	
}