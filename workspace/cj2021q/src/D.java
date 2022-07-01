import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n = sc.nextInt();
		int q = sc.nextInt();
		while(T-- > 0) {
			System.out.printf("%d %d %d\n", 1, 2, 3);
			int res = sc.nextInt(); if(res == -1) return;
			int[] curr;
			if(res == 1) {
				curr = new int[] {2, 1, 3};
			}
			else if(res == 2) {
				curr = new int[] {1, 2, 3};
			}
			else {//res == 3
				curr = new int[] {1, 3, 2};
			}
			for(int i = 4; i <= n; i++) {
				int lo = 0, hi = i-1;
				while(hi - lo >= 2) {
					int d = hi - lo;
					int a = lo-1 + d/3;
					int b = lo-1 + d*2/3;

					System.out.printf("a %d b %d\n", a, b);
					System.out.printf("%d %d %d\n", curr[a], curr[b], i);
					res = sc.nextInt(); if(res == -1) return;
					if(res == curr[a]) {
						hi = a;
					}
					else if(res == curr[b]) {
						lo = b+1;
					}
					else {//res == i
						lo = a+1; hi = b;
					}
					System.out.printf("lo %d hi %d\n", lo, hi);
				}
				int[] nextarr = new int[curr.length+1];
				if(lo == hi) {
					for(int j = 0; j < lo; j++) {
						nextarr[j] = curr[j];
					}
					nextarr[lo] = i;
					for(int j = lo+1; j < nextarr.length; j++) {
						nextarr[j] = curr[j-1];
					}
				}
				else {//hi == lo+1
					System.out.printf("%d %d %d\n", curr[lo], curr[hi], i);
					res = sc.nextInt(); if(res == -1) return;
					if(res == curr[lo]) {
						for(int j = 0; j < lo; j++) {
							nextarr[j] = curr[j];
						}
					}
					else if(res == curr[b]) {
						lo = b+1;
					}
					else {//res == i
						lo = a+1; hi = b;
					}
				}
				
			}
			
			
		}

	}
	

}
