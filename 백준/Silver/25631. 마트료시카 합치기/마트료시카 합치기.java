import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		int num = 0;
		int cnt = 1;
		int prevCnt = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i] == arr[i - 1]) {
				if (cnt < ++prevCnt) {
					num = arr[i];
					cnt = prevCnt;
				}
			}
			else prevCnt = 1;
		}
		
		System.out.print(cnt);
	
	}
	
}