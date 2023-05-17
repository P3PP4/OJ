import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] fibo = new int[45];
		fibo[1] = 1;
		for (int i = 2; i < 45; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine());
			int i = 44;
			while (0 < N) {
				if (fibo[i] <= N) {
					N -= fibo[i];
					pq.offer(fibo[i]);
				}
				i--;
			}
			
			while (!pq.isEmpty()) sb.append(pq.poll()).append(" ");
			sb.append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}