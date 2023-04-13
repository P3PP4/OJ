import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
tc:		for (int t = 0; t < T; t++) {
			int K = Integer.parseInt(br.readLine());
			String[] word = new String[K];
			for (int k = 0; k < K; k++) {
				word[k] = br.readLine();
			}
			
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < K; j++) {
					if (i == j) continue;
					
					String newWord = word[i] + word[j];
					int head = 0;
					int tail = newWord.length() - 1;
					
					while (true) {
						if (tail <= head) {
							sb.append(newWord).append("\n");
							continue tc;
						} else if (newWord.charAt(head) == newWord.charAt(tail)) {
							head++;
							tail--;
						} else break;
					}
				}
			}
			sb.append(0).append("\n");
		}
		
		System.out.print(sb);
	
	}
	
}