import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
	
		int num = Integer.parseInt(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			int input = Integer.parseInt(st.nextToken());
			max = Math.max(max, input);
			min = Math.min(min, input);
		}
		
		System.out.print(min * max);
	
	}
	
}