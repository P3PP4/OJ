import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int N, result;
	static List<Integer> input = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input.add(Integer.parseInt(st.nextToken()));
		}
		
		func(2, 0);
		
		System.out.print(result);
	
	}
	
	static void func(int cnt, int sum) {
		if (cnt == N) {
			if (result < sum) result = sum;
			return;
		}
		
		for (int i = 1; i < input.size() - 1; i++) {
			int temp = input.remove(i);
			func(cnt + 1, sum + input.get(i - 1) * input.get(i));
			input.add(i, temp);
		}
	}
	
}