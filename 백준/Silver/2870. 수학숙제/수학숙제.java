import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<BigInteger> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			int len = s.length();
			for (int j = 0; j < len; j++) {
				if ('0' <= s.charAt(j) && s.charAt(j) <= '9') {
					int end = j + 1;
					while (end < len && '0' <= s.charAt(end) && s.charAt(end) <= '9') end++;
					pq.offer(new BigInteger(s.substring(j, end)));
					j += (end - j - 1);
				}
			}
		}
		
		while (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
		System.out.print(sb);
	
	}
	
}