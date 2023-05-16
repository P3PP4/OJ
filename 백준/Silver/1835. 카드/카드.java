import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = N; i > 0; i--) {
			dq.addFirst(i);
			for (int j = 0; j < i; j++) {
				dq.addFirst(dq.pollLast());
			}
		}
		
		while (!dq.isEmpty()) sb.append(dq.pollFirst()).append(" ");
		System.out.print(sb);
	
	}
	
}