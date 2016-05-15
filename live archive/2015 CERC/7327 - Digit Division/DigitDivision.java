import java.util.*;
import java.io.*;
public class DigitDivision {
	static final int M = (int)1e9+7;
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) return;
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			char[] s = br.readLine().toCharArray();
			int currmod = 0; int pow = 0;
			for(char c: s){
				currmod = (currmod*10 + c-'0')%m;
				if(currmod == 0){
					pow++; currmod = 0;
				}
			}
			int res = currmod%m==0? 1: 0;
			for(int i = 0; i < pow-1; i++){
				res *= 2; res %= M;
			}
			System.out.println(res);
		}
	}
}
