import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] arr = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();
		String temp = "";
		int index = 0;
		while (true) {
			if (index < N) {
				if (index < M) {
					temp += arr[A.charAt(index) - 'A'];
					temp += arr[B.charAt(index) - 'A'];
				} else temp += arr[A.charAt(index) - 'A'];
			} else if (index < M) temp += arr[B.charAt(index) - 'A'];
			else break;
			index++;
		}
		
		while (temp.length() > 2) {
			String newString = "";
			int len = temp.length();
			for (int i = 1; i < len; i++) {
				newString += ((temp.charAt(i - 1) - '0') + (temp.charAt(i) - '0')) % 10;
			}
			temp = newString;
		}
		
		if (temp.charAt(0) == '0') System.out.print(temp.charAt(1) + "%");
		else System.out.print(temp + "%");
	
	}
	
}