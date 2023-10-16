import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		boolean[] isQ = new boolean[N];
		Deque<Integer> dq = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(st.nextToken()) == 0) {
				isQ[i] = true;
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int B = Integer.parseInt(st.nextToken());
			if (isQ[i]) {
				dq.addFirst(B);
			}
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			dq.offer(Integer.parseInt(st.nextToken()));
			sb.append(dq.poll()).append(" ");
		}
		System.out.print(sb);
	
	}
	
}