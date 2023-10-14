import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, min = Integer.MAX_VALUE;
	static String numbers;
	static boolean[] used;
	static int[] demand = new int[4];
	static int[][] ingredients;
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ingredients = new int[N + 1][5];
		used = new boolean[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		demand[0] = Integer.parseInt(st.nextToken());
		demand[1] = Integer.parseInt(st.nextToken());
		demand[2] = Integer.parseInt(st.nextToken());
		demand[3] = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ingredients[i][0] = Integer.parseInt(st.nextToken());
			ingredients[i][1] = Integer.parseInt(st.nextToken());
			ingredients[i][2] = Integer.parseInt(st.nextToken());
			ingredients[i][3] = Integer.parseInt(st.nextToken());
			ingredients[i][4] = Integer.parseInt(st.nextToken());
		}
		
		find(1, 0, 0, 0, 0, 0, "");
		
		System.out.print(min == Integer.MAX_VALUE ? -1 : min + "\n" + numbers);
	
	}
	
	static void find(int idx, int a1, int a2, int a3, int a4, int a5, String s) {
		if (idx == N + 1) {
			if (demand[0] <= a1 && demand[1] <= a2 && demand[2] <= a3 && demand[3] <= a4 && a5 < min) {
				min = a5;
				numbers = s;
			}
			return;
		}
        
		if (!(ingredients[idx][0] == 0 && ingredients[idx][1] == 0 && ingredients[idx][2] == 0 && ingredients[idx][3] == 0 && ingredients[idx][4] == 0)) {
			used[idx] = true;
			find(idx + 1, a1 + ingredients[idx][0], a2 + ingredients[idx][1], a3 + ingredients[idx][2], a4 + ingredients[idx][3], a5 + ingredients[idx][4], s + idx + " ");
		}
		used[idx] = false;
		find(idx + 1, a1, a2, a3, a4, a5, s);
	}
	
}