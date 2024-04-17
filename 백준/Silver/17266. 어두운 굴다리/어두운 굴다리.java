import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int first = Integer.parseInt(st.nextToken());
		arr[first]++;
		int last = first;
		for (int i = 0; i < M - 1; i++) {
			last = Integer.parseInt(st.nextToken());
			arr[last]++;
		}
		
		int height = 1;
		for (int i = first; i < last;) {
			int next = i + 1;
			while (arr[next] == 0) {
				next++;
			}
			int space = (next - i + 1) / 2;
			if (space > height) height = space;
			i = next;
		}
		if (first > height) height = first;
		if (N - last > height) height = N - last;
		
		System.out.print(height);
		
	}
	
}