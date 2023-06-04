import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] child;
	static ArrayList<Integer> root;
	static int N, cnt, target;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		child = new ArrayList[N];
		root = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			child[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(st.nextToken());
			if (input == -1) root.add(i);
			else child[input].add(i);
		}
		target = Integer.parseInt(br.readLine());
		
		for (Integer r : root) go(r);
		
		System.out.print(cnt);
	
	}
	
	static void go(int index) {
		if (index == target) return;
		
		if (child[index].isEmpty() || (child[index].size() == 1 && child[index].get(0) == target)) {
			cnt++;
			return;
		}
		
		for (Integer i : child[index]) go(i);
	}
	
}