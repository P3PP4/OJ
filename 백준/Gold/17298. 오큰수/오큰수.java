import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		
		Stack<Integer> s = new Stack<>();
		for (int i = N - 1; i > 0; i--) s.push(input[i]);
			
		int index = 1;
		int[] NGE = new int[N];
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		
		while(!s.empty()) {
			
			int num = s.pop();
			
			for (int i = list.size() - 1; i >= 0; i--) {
				
				if(input[list.get(i)] >= num) break;
				
				NGE[list.get(i)] = num;
				list.remove(i);
				
			}
			
			list.add(index++);
			
		}
		
		for (int i = 0; i < N; i++) sb.append(NGE[i] == 0 ? -1 : NGE[i]).append(" ");
			
		
		System.out.print(sb.toString());
		
	}
	
}