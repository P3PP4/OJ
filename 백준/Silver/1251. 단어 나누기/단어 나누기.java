import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder[] sb = new StringBuilder[3];
		PriorityQueue<String> pq = new PriorityQueue<>();
		int len = s.length();
		for (int i = 0; i < len - 2; i++) {
			sb[0] = new StringBuilder().append(s.substring(0, i + 1)).reverse();
			for (int j = i + 1; j < len - 1; j++) {
				sb[1] = new StringBuilder().append(s.substring(i + 1, j + 1)).reverse();
				sb[2] = new StringBuilder().append(s.substring(j + 1, len)).reverse();
				pq.offer("" + sb[0] + sb[1] + sb[2]);
			}
		}
		
		System.out.print(pq.poll());
	
	}
	
}