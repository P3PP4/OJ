import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		int cnt = 0;
		int size = N;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int temp = 0;
			while (dq.peekFirst() != target) {
				dq.addLast(dq.pollFirst());
				temp++;
			}
			if (temp <= size >> 1) cnt += temp;
			else cnt += size - temp;
			dq.pollFirst();
			size--;
		}
		
		System.out.print(cnt);
		
	}
	
}