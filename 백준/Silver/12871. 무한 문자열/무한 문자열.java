import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		String str1 = "";
		String str2 = "";
		for(int i = 0; i < b.length(); i++) {
			str1 += a;
		}
		for(int i = 0; i < a.length(); i++) {
			str2 += b;
		}
		if(str1.equals(str2)) System.out.print(1);
		else System.out.print(0);
		
	}
	
}