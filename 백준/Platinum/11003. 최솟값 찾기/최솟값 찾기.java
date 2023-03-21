import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N, L, num;
	static ArrayDeque<int[]> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num = Integer.parseInt(st.nextToken());
			while (!dq.isEmpty() && num < dq.peekLast()[1]) dq.pollLast();
			dq.offer(new int[] { i, num });
			if (dq.peek()[0] <= i - L) dq.poll();
			sb.append(dq.peek()[1]).append(" ");
		}
		
		System.out.print(sb);
	
	}
	
}