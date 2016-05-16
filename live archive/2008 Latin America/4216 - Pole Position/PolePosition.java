import java.util.*;
public class PolePosition {
	public static void main(String...thegame){
		Scanner seer = new Scanner(System.in);
		while(true){
			int n = seer.nextInt(); if(n == 0) return;
			int[] pos = new int[n]; boolean valid = true;
			for(int i = 0; i < n; i++){
				int k = seer.nextInt();
				int d = seer.nextInt();
				if(!valid) continue;
				int j = i+d;
				if(j < 0 || j >= n) {
					valid = false; continue;
				}
				if(pos[j] > 0){
					valid = false; continue;
				}
				pos[j] = k;
			}
			if(!valid) System.out.println("-1");
			else{
				StringBuilder sb = new StringBuilder();
				for(int k: pos) sb.append(k+" ");
				System.out.println(sb.toString().trim());
			}
		}
	}
}
