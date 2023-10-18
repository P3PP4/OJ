import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
			if (o1.length() != o2.length()) return o1.length() - o2.length();
			else {
				int o1cnt = 0;
				int o2cnt = 0;
				for (int i = 0; i < o1.length(); i++) {
					if ('1' <= o1.charAt(i) && o1.charAt(i) <= '9') o1cnt += o1.charAt(i) - '0';
					if ('1' <= o2.charAt(i) && o2.charAt(i) <= '9') o2cnt += o2.charAt(i) - '0';
				}
				if (o1cnt == o2cnt) return o1.compareTo(o2);
				return o1cnt - o2cnt;
			}
		});
		for (int i = 0; i < N; i++) {
			pq.offer(br.readLine());
		}
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	
	}
	
}