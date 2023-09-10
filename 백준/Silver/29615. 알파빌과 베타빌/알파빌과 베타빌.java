import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] input = new int[N];
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			if (set.contains(input[i])) cnt++;
		}
		System.out.print(M - cnt);
		
	}
	
}