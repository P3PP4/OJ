import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s1 = br.readLine();
		int wordChars = s1.length();
		char[] word = s1.toCharArray();
		int[] wordCnt = new int[26];
        for (char c : word) {
            wordCnt[c - 'A']++;
        }
		int same = 0;
		for (int i = 1; i < N; i++) {
			String s2 = br.readLine();
			int compareChars = s2.length();
			if (1 < Math.abs(wordChars - compareChars)) continue;
			int diff = 0;
			char[] compare = s2.toCharArray();
			int[] compareCnt = new int[26];
            for (char c : compare) {
                compareCnt[c - 'A']++;
            }
			
			for (int j = 0; j < 26; j++) {
				int n = Math.abs(wordCnt[j] - compareCnt[j]);
				if (1 < n) {
					diff = 9;
					break;
				}
				diff += n;
			}
			if (diff <= 2) same++;
		}
		System.out.print(same);
		
	}
	
}