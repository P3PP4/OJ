import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(st.nextToken()));
		}
		
		int odd  = Integer.MAX_VALUE;
		int even = Integer.MAX_VALUE;
		int lastOdd  = -1000000001;
		int lastEven = -1000000001;
		int pre = pq.poll();
		if (pre % 2 == 0) lastEven = pre;
		else lastOdd = pre;
		
		while (!pq.isEmpty()) {
			int next = pq.poll();;
			
			if (-1000000000 <= lastEven) {
				int oddOrEven = (next - lastEven) % 2;
				if (oddOrEven == 0) even = Math.min(even, next - lastEven);
				else odd = Math.min(odd, next - lastEven);
			}
			if (-1000000000 <= lastOdd) {
				int oddOrEven = (next - lastOdd) % 2;
				if (oddOrEven == 0) even = Math.min(even, next - lastOdd);
				else odd = Math.min(odd, next - lastOdd);
			}
			
			if (next % 2 == 0) lastEven = next;
			else lastOdd = next;
			
		}
		
		System.out.print((even == Integer.MAX_VALUE ? -1 : even) + " " + (odd == Integer.MAX_VALUE ? -1 : odd));
		
	}
	
}