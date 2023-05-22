import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			boolean[] visited = new boolean[10000];
			Queue<Info> q = new LinkedList<>();
			visited[start] = true;
			q.offer(new Info(start, ""));
			
			while (!q.isEmpty()) {
				Info i = q.poll();
				
				if (i.num == end) {
					sb.append(i.s).append("\n");
					break;
				}
				
				int next = left(i.num);
				if (!visited[next]) {
					q.offer(new Info(next, i.s + "L"));
					visited[next] = true;
				}
				
				next = right(i.num);
				if (!visited[next]) {
					q.offer(new Info(next, i.s + "R"));
					visited[next] = true;
				}
				
				next = mul(i.num);
				if (!visited[next]) {
					q.offer(new Info(next, i.s + "D"));
					visited[next] = true;
				}
				
				next = minus(i.num);
				if (!visited[next]) {
					q.offer(new Info(next, i.s + "S"));
					visited[next] = true;
				}
			}
		}
		
		System.out.print(sb);
	
	}
	
	static int left(int num) {
		int next = num * 10;
		return next / 10000 + next % 10000;
	}
	
	static int right(int num) {
		return (num % 10) * 1000 + num / 10;
	}
	
	static int mul (int num) {
		return (num * 2) % 10000;
	}
	
	static int minus (int num) {
		return num == 0 ? 9999 : num - 1;
	}
	
	static class Info {
		int num;
		String s;
		
		Info (int num, String s) {
			this.num = num;
			this.s = s;
		}
	}
	
}