import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Comparator.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (!pq2.isEmpty() && pq2.peek() >= temp) pq2.offer(temp);
			else pq1.offer(temp);
			if (pq1.size() == pq2.size()) {
				pq1.offer(pq2.poll());
			} else if (pq1.size() > 2 && pq1.size() > pq2.size() + 2) {
				pq2.offer(pq1.poll());
			}
			sb.append(pq1.peek()).append("\n");
		}
		System.out.print(sb);
		
	}
	
}