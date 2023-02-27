import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static long pre, now, max;
	
	public static void main(String[] args) throws Exception {
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pq.offer(Long.parseLong(st.nextToken()));
		} // end of input
		
		while(!pq.isEmpty()) {
		
			now = pq.poll();
			
			if (now == 0) continue;
			
			max = Math.max(max, now);
			
			if (pre == now) {
				pre = 0;
				pq.offer(now * 2);
			} else pre = now;
		
		}
		
		System.out.println(max);
	
	}
	
}