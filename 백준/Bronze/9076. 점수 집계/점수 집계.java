import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		int[] score = new int[5];
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 5; i++) {
				score[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(score);
			int max = 0;
			int min = 99;
			for (int i = 1; i < 4; i++) {
				if (score[i] < min) min = score[i];
				if (score[i] > max) max = score[i];
			}
			if (4 <= max - min) sb.append("KIN\n");
			else sb.append(score[1] + score[2] + score[3]).append("\n");
		}
		System.out.print(sb);
	
	}
	
}