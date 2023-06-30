import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) s.push(Integer.parseInt(st.nextToken()));
			else if (a == 2) sb.append(s.isEmpty() ? -1 : s.pop()).append("\n");
			else if (a == 3) sb.append(s.size()).append("\n");
			else if (a == 4) sb.append(s.isEmpty() ? 1 : 0).append("\n");
			else if (a == 5) sb.append(s.isEmpty() ? -1 : s.peek()).append("\n");
		}
		System.out.print(sb);
	
	}
	
}