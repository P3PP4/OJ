import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		String[] str = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<String> pq = new PriorityQueue<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		for (int i = M; i <= N; i++) {
			String s = "";
			if (9 < i) s += str[i / 10];
			s += str[i % 10] + " " + i;
			pq.offer(s);
		}
		
		int cnt = 0;
		while (!pq.isEmpty()) {
			st = new StringTokenizer(pq.poll(), " ");
			st.nextToken();
			sb.append(st.nextToken()).append(" ");
			if (++cnt == 10) {
				cnt = 0;
				sb.append("\n");
			}
		}
		System.out.print(sb);
	
	}
	
}