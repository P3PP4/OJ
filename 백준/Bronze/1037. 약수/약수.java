import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int max = 0;
		int min = Integer.MAX_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			int input = Integer.parseInt(st.nextToken());
			max = Math.max(max, input);
			min = Math.min(min, input);
		}
		
		System.out.print(min * max);
	
	}
	
}