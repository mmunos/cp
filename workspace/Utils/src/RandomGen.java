import java.util.*;
import java.io.*;
public class RandomGen {

	public static void main(String[] args) {
		Random r = new Random();
		int T = 1000;
		System.out.println(T);
		for(int i = 0; i < T; i++) {
			System.out.println("5");
			printRandomArray(r, 5, 1, 10, false);
		}
//		System.out.println("8 0");
//		printRandomArray(r, 9, -100, 100, false);
//		printTree(r, 10);
//		for(int i = 0; i < 100; i++) {
//			int n = r.nextInt(5)+1;
//			System.out.println(n);
//			printRandomArray(r, n, 1, 10, true);
//			int q = 100;
//			System.out.println(q);
//			for(int j = 0; j < q; j++){
//				System.out.println(j+1);
//			}
//		}
//		System.out.println(10);
//		printRandomArray(r, 9, 2, 10, true);
//		printRangeQueries(r, 5000, 100000);
	}
	static void printTree(Random r, int n) {
		int[] parent = new int[n];
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < n; i++){
			parent[i] = r.nextInt(i);
			sb.append((parent[i]+1)+" "+(i+1)+"\n");
		}
		System.out.println(sb.toString());
	}
	static void printRangeQueries(Random r, int q, int n) {
		StringBuilder sb = new StringBuilder();
		while(q-- > 0) {
			int a = r.nextInt(n)+1;
			int b = r.nextInt(n)+1;
			if(a > b) {int aux = a; a = b; b = aux;}
			int k = r.nextInt(b-a)+1;
			sb.append(a+" "+b+" "+k+"\n");
		}
		System.out.print(sb.toString());
	}
	static void printRandomArray(Random r, int n, int min, int max, boolean allDistinct) {
		long[] arr = new long[n];
		HashSet<Long> seen = new HashSet<>();
		for(int i = 0; i < n; i++) {
			arr[i] = r.nextInt(max-min)+min;
			if(allDistinct) {
				while(seen.contains(arr[i])) arr[i] = r.nextInt(max-min)+min;
				seen.add(arr[i]);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(long k: arr) sb.append(k+" ");
		System.out.println(sb.toString().trim());
	}
	static void method3(Random r) {
		int w = 10;
		int h = 10;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i = 0; i <= w; i++) {
			if(r.nextDouble() < 0.5) {
				arr.add(i);
			}
		}
		ArrayList<Integer> brr = new ArrayList<>();
		for(int i = 0; i <= h; i++) {
			if(r.nextDouble() < 0.5) {
				brr.add(i);
			}
		}
		int n = arr.size();
		int m = brr.size();
		System.out.println(w+" "+h+" "+n+" "+m);
		for(int a: arr) System.out.print(a+" ");
		System.out.println("");
		for(int b: brr) System.out.print(b+" ");
		System.out.println("");
	}
	static void method2(Random r) {
		int n = 100000;
		int maxa = 100000000;
		StringBuilder sb = new StringBuilder();
		sb.append(n+"\n");
		for(int i = 0; i < n/1000; i++) {
			sb.append("0 ");
		}
		for(int i = n/1000; i <= n; i++) {
			int a = r.nextInt(maxa+1);
			sb.append(a+" ");
		}
		sb.replace(sb.length()-1, sb.length(), "\n");
		PrintWriter pw = new PrintWriter(System.out);
		pw.print(sb.toString());
		pw.flush();
	}
	static void method1(Random r) {
		int T = 100;
		int maxn = 500, minn = 1;
		int maxr = 200000, minr = 0;
		long maxk = 1000000000000L, mink = 0;
		System.out.println(T);
		while(T-- > 0) {
			int n = r.nextInt(maxn-minn)+minn;
			int rr = r.nextInt(maxr-minr)+minr;
			long k = Math.abs(r.nextLong()) % (maxk - mink) +mink;
			System.out.println(n+" "+rr+" "+k);
		}

	}

}
