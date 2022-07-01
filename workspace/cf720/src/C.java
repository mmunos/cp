import java.util.*;
import java.io.*;
public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-->0) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			int[] ms = new int[n-1];
			int one = -1;
			for(int i = 0; i < n-1; i++) {
				System.out.printf("? %d %d %d %d\n", 2, i+1, i+2, 1);
				ms[i] = sc.nextInt();
				if(ms[i] == 1) {
					arr[i] = 1; one = i; break;
				}
				if(i > 0 && ms[i-1] < ms[i]) {
					if(ms[i-1] != 2) arr[i-1] = ms[i-1];
				}
				else if(i > 0 && ms[i-1] == ms[i]) {
					if(ms[i] != 2) arr[i] = ms[i];
				}
				else if(i > 0 && ms[i-1] > ms[i]) {
					if(ms[i] != 2)  arr[i+1] = ms[i];
				}
			}
			if(one < 0) {
				one = n-1; arr[n-1] = 1;
			}
			for(int i = 0; i < n; i++) {
				if(arr[i] != 0) continue;
				System.out.printf("? %d %d %d %d\n", 1, one+1, i+1, n-1);
				arr[i] = sc.nextInt(); 
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < n; i++) {
				sb.append(arr[i]+" ");
			}
			System.out.println("! "+sb.toString().trim());
		}
	}
	
}
