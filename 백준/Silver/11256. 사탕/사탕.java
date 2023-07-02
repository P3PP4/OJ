import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int J = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				pq.offer(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
			}
			
			int cnt = 0;
			while (J > 0) {
				J -= pq.poll();
				cnt++;
			}
			sb.append(cnt).append("\n");
		}
		System.out.print(sb);
	
	}
	
}