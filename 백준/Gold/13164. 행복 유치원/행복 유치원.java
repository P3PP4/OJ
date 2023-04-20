import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		if (N == K) {
			System.out.print(0);
			return;
		}
		int[] input = new int[N];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} // end of input
		
		for (int i = 1; i < N; i++) {
			pq.offer(input[i] - input[i - 1]);
		}
		
		int sum = input[N - 1] - input[0];
		for (int i = 1; i < K; i++) {
			sum -= pq.poll();
		}
		
		System.out.print(sum);
	
	}
	
}