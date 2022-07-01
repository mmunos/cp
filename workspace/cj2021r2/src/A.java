import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int n = sc.nextInt();
		while(T--> 0) {
			for(int i = 0; i < n-1; i++) {
				System.out.printf("M %d %d\n", i+1, n);
				int m = sc.nextInt();
				if(m != i+1) {
					System.out.printf("S %d %d\n", i+1, m);
					int res = sc.nextInt(); //1
				}
			}
			System.out.println("D");
			int res = sc.nextInt(); if(res == -1) return;
		}
	}
	

}
