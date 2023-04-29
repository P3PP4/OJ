import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] q = new int[5];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (x == 0 || y == 0) q[0]++;
			else if (0 < x && 0 < y) q[1]++;
			else if (x < 0 && 0 < y) q[2]++;
			else if (x < 0 && y < 0) q[3]++;
			else if (0 < x && y < 0) q[4]++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 4; i++) {
			sb.append("Q").append(i).append(": ").append(q[i]).append("\n");
		}
		sb.append("AXIS: ").append(q[0]);
		System.out.print(sb);
	
	}
	
}