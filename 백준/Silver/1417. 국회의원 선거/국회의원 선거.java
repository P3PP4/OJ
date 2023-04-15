import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.print(0);
			return;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		int me = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		while (true) {
			int max = pq.poll();
			if (max < me) break;
			cnt++;
			me++;
			pq.offer(max - 1);
		}
		
		System.out.print(cnt);
		
	}
	
}