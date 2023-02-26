import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception {
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // end of input
		Arrays.sort(arr);
		int pre = -1234;
        
		for (int i = 0; i < N; i++) {
			if (pre == arr[i]) continue;
			
			pre = arr[i];
			sb.append(arr[i]).append(" ");
		}
		
		System.out.print(sb);
		
	}
	
}
