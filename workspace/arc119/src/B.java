import java.util.*;
public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		char[] s = sc.next().toCharArray();
		char[] t = sc.next().toCharArray();
		ArrayList<Integer> a = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(s[i] == '0') a.add(i);
		}
		ArrayList<Integer> b = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if(t[i] == '0') b.add(i);
		}
		if(a.size() != b.size()) System.out.println("-1");
		else {
			long res = 0;
			int m = a.size();
			for(int i = 0; i < m; i++) {
				if(a.get(i).compareTo(b.get(i)) != 0) res++;
			}
			System.out.println(res);
		}
	}

}
