import java.util.*;
public class Bingo {
	static int[] arr = new int[91];
	public static void main(String...thegame){
		Scanner seer = new Scanner(System.in);
		while(true){
			int n = seer.nextInt(); if(n == 0) return;
			int b = seer.nextInt();
			int[] difs = new int[n+1]; difs[0] = 1;
			for(int i = 0; i < b; i++){
				arr[i] = seer.nextInt();
				for(int j = 0; j < i; j++){
					difs[Math.abs(arr[i]-arr[j])]++;
				}
			}
			Arrays.sort(difs);
			System.out.println(difs[0] > 0 ? "Y":"N");
		}
	}
}
