import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			if (x == 0 && y == 0) {
				sb.append("AXIS");
				break;
			}
			
			if (x == 0 || y == 0) {
				sb.append("AXIS\n");
				continue;
			}
			
			if (x > 0) {
				if (y > 0) sb.append("Q1\n");
				else sb.append("Q4\n");
			}
			else {
				if (y > 0) sb.append("Q2\n");
				else sb.append("Q3\n");
			}
		}
		System.out.print(sb);
	
	}
	
}