import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			switch (a) {
				case 1:
					dq.addFirst(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					dq.addLast(Integer.parseInt(st.nextToken()));
					break;
				case 3:
					sb.append(dq.isEmpty() ? -1 : dq.pollFirst()).append("\n");
					break;
				case 4:
					sb.append(dq.isEmpty() ? -1 : dq.pollLast()).append("\n");
					break;
				case 5:
					sb.append(dq.size()).append("\n");
					break;
				case 6:
					sb.append(dq.isEmpty() ? 1 : 0).append("\n");
					break;
				case 7:
					sb.append(dq.isEmpty() ? -1 : dq.peekFirst()).append("\n");
					break;
				case 8:
					sb.append(dq.isEmpty() ? -1 : dq.peekLast()).append("\n");
			}
		}
		System.out.print(sb);
	
	}
	
}