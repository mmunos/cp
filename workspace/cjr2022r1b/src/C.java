import java.util.*;
public class C {
	
	static int rot(int x, int k) {
		int aux = x;
		while(k-- > 0) {
			if((aux & 1) > 0) {
				aux >>= 1; aux += (1 << 7);
			}
			else {
				aux >>= 1;
			}
		}
		return aux;
	}
	
	static String str(int x) {
		StringBuilder sb = new StringBuilder();
		for(int i = 7; i >= 0; i--) {
			if((x & (1 << i)) > 0) sb.append('1');
			else sb.append('0');
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer>[] hs = new HashSet[256];
		for(int i = 0; i < 256; i++) {
			hs[i] = new HashSet<>();
		}
		for(int x = 0; x < 256; x++) {
			int min = x;
			for(int k = 0; k < 8; k++) {
				min = Math.min(min, rot(x, k));
			}
			hs[min].add(x);
		}
		for(int i = 0; i < 256; i++) {
			if(hs[i].isEmpty()) continue;
			System.out.print(str(i)+": ");
			for(int x: hs[i]) {
				System.out.print(str(x)+" ");
			}
			System.out.println("");
		}
	}

}
