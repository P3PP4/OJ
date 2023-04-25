import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] order = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			switch (order[N - i]) {
				case 1:
					dq.offerFirst(i);
					break;
				case 2:
					int tmp = dq.pollFirst();
					dq.offerFirst(i);
					dq.offerFirst(tmp);
					break;
				case 3:
					dq.offerLast(i);
					break;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while (!dq.isEmpty()) {
			sb.append(dq.pollFirst()).append(" ");
		}
		System.out.print(sb);
	
	}
	
}