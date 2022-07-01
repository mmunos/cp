import java.util.*;
public class p106 {

	public static void main(String[] args) {
		int n = 12;
		int count = 0;
		for(int mask = 0; mask < (1<<n); mask++) {
			for(int mask2 = 0; mask2 < (1<<n); mask2++) {
				if((mask & mask2) == 0) {
					if(check(mask, mask2, n)) count++;
				}
			}
		}
		System.out.println(count);
	}
	static boolean check(int a, int b, int n) {
		ArrayList<Integer> g1 = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if((a & (1 << i)) > 0) {
				g1.add(i);
			}
		}
		ArrayList<Integer> g2 = new ArrayList<>();
		for(int i = 0; i < n; i++) {
			if((b & (1 << i)) > 0) {
				g2.add(i);
			}
		}
		if(g1.size() != g2.size()) return false;
		int m = g1.size();
		int x = 0, y = 0;
		for(int i = 0; i < m; i++) {
			if(g1.get(i) > g2.get(i)) {
				x++;
			}
			else {
				y++;
			}
		}
		if(x == 0 || y == 0) return false;
		else return true;
	}

}
