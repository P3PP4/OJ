import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0) break;
			
			PriorityQueue<Info> pq = new PriorityQueue<>(new Com());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				pq.offer(new Info(st.nextToken(), Double.parseDouble(st.nextToken()), i));
			}
			
			Info info = pq.poll();
			double h = info.height;
			sb.append(info.name).append(" ");
			
			while (!pq.isEmpty()) {
				Info next = pq.poll();
				if (next.height != h) break;
				
				sb.append(next.name).append(" ");
			}
			sb.append("\n");
			
		}
		
		System.out.print(sb);
	
	}
	
	static class Info {
		String name;
		double height;
		int num;
		
		public Info(String name, double height, int num) {
			this.name = name;
			this.height = height;
			this.num = num;
		}
		
	}
	
	static class Com implements Comparator<Info> {
		
		@Override
		public int compare(Info o1, Info o2) {
			if (o1.height == o2.height) return o1.num - o2.num;
			return Double.compare(o2.height, o1.height);
		}
	}
	
}