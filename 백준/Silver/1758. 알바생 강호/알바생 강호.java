import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 1;
		long sum = 0;
		while (!pq.isEmpty()) {
			long num = pq.poll() - (cnt++ - 1);
			if (num < 0) break;
			sum += num;
		}
		
		System.out.print(sum);
	
	}
	
}