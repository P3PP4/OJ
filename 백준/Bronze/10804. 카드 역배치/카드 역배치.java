import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] card;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		card = new int[21];
		for (int i = 1; i <= 20; i++) {
			card[i] = i;
		}
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			swap(start, end);
		}
		
		for (int i = 1; i <= 20; i++) {
			sb.append(card[i]).append(" ");
		}
		System.out.print(sb);
	
	}
	
	static void swap(int s, int e) {
		for (int i = s; i <= (s + e) / 2; i++) {
			int temp = card[i];
			card[i] = card[e + s - i];
			card[e + s - i] = temp;
		}
	}
	
}