import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int l = 0;
		int r = N - 1;
		int min = Integer.MAX_VALUE;
		int minL = 0;
		int minR = 0;
		while (l < r) {
			int diff = Math.abs(input[l] + input[r]);
			if (diff < min) {
				min = diff;
				minL = l;
				minR = r;
			}
			
			if (input[l] + input[r] < 0) l++;
			else if (0 < input[l] + input[r]) r--;
			else break;
		}
		
		System.out.print(input[minL] + " " + input[minR]);
		
	}
	
}