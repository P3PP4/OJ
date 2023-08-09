import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N + 1];
		Stack<Integer> s = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx = 1;
		int target = 1;
		while (target <= N) {
			if (idx <= N && input[idx] == target) {
				target++;
				idx++;
			} else {
				if (!s.isEmpty() && s.peek() == target) {
					target++;
					s.pop();
				} else if (idx < N) {
					s.push(input[idx++]);
				} else {
					System.out.print("Sad");
					return;
				}
			}
		}
		System.out.print("Nice");
		
	}
	
}