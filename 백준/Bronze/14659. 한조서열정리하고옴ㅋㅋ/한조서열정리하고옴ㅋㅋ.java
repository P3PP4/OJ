import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int height = 0;
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			if (height < input[i]) {
				if (max < cnt) max = cnt;
				height = input[i];
				cnt = 0;
			} else cnt++;
		}
		System.out.print(Math.max(max, cnt));
	
	}
	
}