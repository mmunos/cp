import java.util.*;
import java.io.*;
public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println("and 1 2");
		long a_and_b = sc.nextLong(); if(a_and_b < 0) return;
		System.out.println("and 1 3");
		long a_and_c = sc.nextLong(); if(a_and_c < 0) return;
		System.out.println("and 2 3");
		long b_and_c = sc.nextLong(); if(b_and_c < 0) return;
		System.out.println("or 1 2");
		long a_or_b = sc.nextLong(); if(a_or_b < 0) return;
		System.out.println("or 1 3");
		long a_or_c = sc.nextLong(); if(a_or_c < 0) return;
		System.out.println("or 2 3");
		long b_or_c = sc.nextLong(); if(b_or_c < 0) return;
		long[] arr = new long[n];
		for(int bit = 0; bit < 31; bit++) {
			if(!check(a_or_b, bit) && !check(a_or_c, bit)) {//0 0 0 
				
			}
			else if(!check(a_or_b, bit) && check(a_or_c, bit)){//0 0 1
														arr[2] += (1 << bit);
			}
			else if(!check(a_or_c, bit) && check(a_or_b, bit)){//0 1 0
									arr[1] += (1 << bit);
			}
			else if(check(b_and_c, bit) && !check(a_and_b, bit)){//0 1 1
									arr[1] += (1 << bit); arr[2] += (1 << bit);
			}
			else if(!check(b_or_c, bit) && check(a_or_b, bit)){//1 0 0
				arr[0] += (1 << bit);
			}
			else if(check(a_and_c, bit) && !check(a_and_b, bit)){//1 0 1
				arr[0] += (1 << bit); 					arr[2] += (1 << bit);
			}
			else if(check(a_and_b, bit) && !check(a_and_c, bit)) {//1 1 0
				arr[0] += (1 << bit); arr[1] += (1 << bit);
			}
			else if(check(a_and_b, bit) && check(a_and_c, bit)) {// 1 1 1
				arr[0] += (1 << bit); arr[1] += (1 << bit); arr[2] += (1 << bit);
			}
		}
		for(int i = 3; i < n; i++) {
			System.out.printf("and %d %d\n", 1, i+1);
			long a = sc.nextLong(); if(a < 0) return;
			System.out.printf("or %d %d\n", 1, i+1);
			long b = sc.nextLong(); if(b < 0) return;
			long c = a ^ b;
			arr[i] = arr[0] ^ c;
		}
		sort(arr);
		System.out.printf("finish %d\n",arr[k-1]);
	}
	static void sort(long[] arr) {
		Random r = new Random();
		for(int i = 0; i < arr.length; i++) {
			int ind = r.nextInt(arr.length);
			long aux = arr[ind]; arr[ind] = arr[i]; arr[i] = aux; 
		}
		Arrays.sort(arr);
	}
	static boolean check(long x, int b) {
		return (x & (1 << b)) > 0;
	}

}
