import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		
		for (int i = 1; i < 9; i++) {
			pq.offer(new int[] { Integer.parseInt(br.readLine()), i });
		}
		
		PriorityQueue<Integer> pq2 = new PriorityQueue<>();
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			int[] a = pq.poll();
			sum += a[0];
			pq2.offer(a[1]);
		}
		
		sb.append(sum).append("\n");
		for (int i = 0; i < 5; i++) {
			sb.append(pq2.poll()).append(" ");
		}
		System.out.print(sb);
	}
	
}