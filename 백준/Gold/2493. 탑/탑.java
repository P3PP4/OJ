import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N + 1];
		int[] get = new int[N + 1];
		HashMap<Integer, Integer> map = new HashMap<>();
		input[0] = 123456789;
		map.put(123456789, 0);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			map.put(input[i], i);
		}
		
		Stack<Integer> s = new Stack<>();
		s.push(123456789);
		for (int i = 1; i <= N; i++) {
			int now = input[i];
			
			while (!s.isEmpty() && s.peek() < now) {
				s.pop();
			}
			
			get[i] = map.get(s.peek());
			s.push(now);
		}
		
		for (int i = 1; i <= N; i++) {
			sb.append(get[i]).append(" ");
		}
		System.out.print(sb);
	
	}
	
}