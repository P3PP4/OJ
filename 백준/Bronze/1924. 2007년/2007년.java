import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int day = 0;
		for (int i = 1; i < x; i++) {
			day += days[i];
		}
		day = (day + y) % 7;
		switch (day) {
			case 0:
				System.out.print("SUN");
				break;
			case 1:
				System.out.print("MON");
				break;
			case 2:
				System.out.print("TUE");
				break;
			case 3:
				System.out.print("WED");
				break;
			case 4:
				System.out.print("THU");
				break;
			case 5:
				System.out.print("FRI");
				break;
			case 6:
				System.out.print("SAT");
		}
	
	}
	
}