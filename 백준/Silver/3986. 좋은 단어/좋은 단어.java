import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			Stack<Character> stack = new Stack<>();
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < input.length; j++) {
				if (stack.isEmpty() || stack.peek() != input[j]) stack.push(input[j]);
				else stack.pop();
			}
			if (stack.isEmpty()) cnt++;
		}
		
		System.out.print(cnt);
		
	}
	
}