import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int days = 0;
		int stress = 0;
		for (int i = 0; i < N; i++) {
			stress += Integer.parseInt(st.nextToken());
			if (stress >= M) days++;
			if (stress < 0) stress = 0;
		}
		
		System.out.print(days);
		
	}
	
}