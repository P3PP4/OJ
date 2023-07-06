import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		while (st.hasMoreTokens()) pq.offer(Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString()));
		String line = "";
		while ((line = br.readLine()) != null) {
			st = new StringTokenizer(line, " ");
			while (st.hasMoreTokens()) pq.offer(Long.parseLong(new StringBuilder(st.nextToken()).reverse().toString()));
		}
		
		while (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
		System.out.print(sb);
	
	}
	
}