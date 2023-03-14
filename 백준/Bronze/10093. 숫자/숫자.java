import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
	
		st = new StringTokenizer(br.readLine(), " ");
		long cnt = 0;
		long start = Long.parseLong(st.nextToken());
		long end = Long.parseLong(st.nextToken());
		for (long i = Math.min(start, end) + 1; i < Math.max(start, end); i++) {
			cnt++;
			sb.append(i).append(" ");
		}
		
		System.out.print(cnt + "\n" + sb);
	
	}
	
}