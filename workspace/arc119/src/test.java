import java.util.*;
public class test {
	
	public static void main(String...strings) {
		int n = 1000;
		ArrayList<Integer> a = new ArrayList<>(65536);
		ArrayList<Integer> b = new ArrayList<>(65536);
		for(int i = 0; i < n; i++) {
			a.add(i);
			b.add(i);
		}
		System.out.println(a.get(127) == b.get(127));
		System.out.println(a.get(128) == b.get(128));
	}

}
