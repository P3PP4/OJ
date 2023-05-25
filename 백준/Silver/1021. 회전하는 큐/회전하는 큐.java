import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	
	static Deque<Integer> dq = new ArrayDeque<>();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			dq.add(i);
		}
		int cnt = 0;
		int size = N;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			int index = getIndex(size, target);
			if (index <= size / 2) {
				for (int j = 0; j < index; j++) {
					dq.addLast(dq.pollFirst());
				}
				cnt += index;
			} else {
				for (int j = 0; j < size - index; j++) {
					dq.addFirst(dq.pollLast());
				}
				cnt += size - index;
			}
			dq.pollFirst();
			--size;
		}
		
		System.out.print(cnt);
		
	}
	
	static int getIndex(int size, int num) {
		if (size < 2) return 0;
		List<Integer> arr = dq.stream().collect(Collectors.toList());
		for (int i = 0; i < size; i++) {
			if (arr.get(i) == num) return i;
		}
		return 0;
	}
	
}