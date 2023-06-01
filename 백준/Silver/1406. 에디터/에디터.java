import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		LinkedList<Character> list = new LinkedList<>();
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		ListIterator<Character> cursor = list.listIterator();
		while (cursor.hasNext()) cursor.next();
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			char c = str.charAt(0);
			
			switch (c) {
				case 'L':
					if(cursor.hasPrevious()) cursor.previous();
					break;
				case 'D':
					if(cursor.hasNext()) cursor.next();
					break;
				case 'B':
					if(cursor.hasPrevious()) {
						cursor.previous();
						cursor.remove();
					}
					break;
				case 'P':
					cursor.add(str.charAt(2));
					break;
			}
		}
		
		list.forEach(x -> sb.append(x));
		System.out.println(sb);
		
	}
	
}