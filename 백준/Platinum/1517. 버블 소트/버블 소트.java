import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static long cnt;
	static long[] input, temp;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		input = new long[N];
		temp = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		sort(0, N - 1);
		
		System.out.print(cnt);
	
	}
	
	static void sort(int s, int e) {
		if (s == e) return;
		
		int m = (s + e) >> 1;
		sort(s, m);
		sort(m + 1, e);
		
		int i = s;
		int j = m + 1;
		int k = s;
		
		while (i <= m && j <= e) {
			if (input[i] <= input[j]) temp[k++] = input[i++];
			else {
				temp[k++] = input[j++];
				cnt += m - i + 1;
			}
		}
		
		while (i <= m) temp[k++] = input[i++];
		while (j <= e) temp[k++] = input[j++];
		
		for (int l = s; l <= e; l++) {
			input[l] = temp[l];
		}
		
	}
	
}