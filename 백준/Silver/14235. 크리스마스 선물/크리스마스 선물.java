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
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (pq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(pq.poll()).append("\n");
			}
			else {
				for (int j = 0; j < a; j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		System.out.print(sb);
	
	}
	
}