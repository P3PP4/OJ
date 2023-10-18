import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<Character>[] list;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList['Z' + 1];
		for (int i = 'A'; i <= 'Z'; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char parent = s.charAt(0);
			char child1 = s.charAt(2);
			char child2 = s.charAt(4);
			list[parent].add(child1);
			list[parent].add(child2);
		}
		
		first('A');
		sb.append("\n");
		mid('A');
		sb.append("\n");
		last('A');
		
		System.out.print(sb);
		
	}
	
	static void first(char now) {
		if (now == '.') return;
		sb.append(now);
		first(list[now].get(0));
		first(list[now].get(1));
	}
	
	static void mid(char now) {
		if (now == '.') return;
		mid(list[now].get(0));
		sb.append(now);
		mid(list[now].get(1));
	}
	
	static void last(char now) {
		if (now == '.') return;
		last(list[now].get(0));
		last(list[now].get(1));
		sb.append(now);
	}
	
}