import java.util.*;
import java.io.*;
public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Pair> ones = new LinkedList<>();
		LinkedList<Pair> twos = new LinkedList<>(); 
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if((i+j)%2==0) ones.add(new Pair(i,j));
				else twos.add(new Pair(i,j));
			}
		}
		boolean phase1 = true;
		for(int i = 0; i < n*n; i++) {
			int a = sc.nextInt();
			if(phase1) {
				int b;
				if(a == 1) b = 2;
				else b = 1;
				
				if(b == 1) {
					Pair p = ones.removeFirst();
					System.out.println(String.format("%d %d %d\n", b, p.a+1, p.b+1));
					if(ones.isEmpty()) phase1 = false;
				}
				else {
					Pair p = twos.removeFirst();
					System.out.println(String.format("%d %d %d\n", b, p.a+1, p.b+1));
					if(twos.isEmpty()) phase1 = false;
				}
			}
			else {
				if(ones.isEmpty()) {
					int b;
					if(a == 2) b = 3;
					else b = 2;
					Pair p = twos.removeFirst();
					System.out.println(String.format("%d %d %d\n", b, p.a+1, p.b+1));
				}
				else { //twos is empty
					int b;
					if(a == 1) b = 3;
					else b = 1;
					Pair p = ones.removeFirst();
					System.out.println(String.format("%d %d %d\n", b, p.a+1, p.b+1));
				}
			}
		}
	}
	static class Pair{
		long a, b;
		public Pair(long a, long b) {
			this.a = a; this.b = b;
		}
		public String toString() {
			return a+" "+b;
		}
	}
	

}
