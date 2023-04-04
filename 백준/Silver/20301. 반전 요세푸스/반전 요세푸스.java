import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			dq.offer(i);
		}
		
		boolean forward = true;
		int kCnt = 0;
		int mCnt = 0;
		
		while (!dq.isEmpty()) {
			if (++kCnt < K) {
				if (forward) dq.offerLast(dq.pollFirst());
				else dq.offerFirst(dq.pollLast());
			} else {
				kCnt = 0;
				sb.append(dq.pollFirst()).append("\n");
				if (++mCnt == M) {
					mCnt = 0;
					forward = !forward;
				}
				if (!forward && dq.size() != 0) dq.offerFirst(dq.pollLast());
			}
		}
		
		System.out.print(sb);
	
	}
	
}