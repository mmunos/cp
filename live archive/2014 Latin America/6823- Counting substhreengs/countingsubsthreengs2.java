import java.util.*;
import java.io.*;
public class countingsubsthreengs2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) break;
			int n = line.length();
			long[][] mods = new long[3][n];
			long res = 0;
			for(int i = 0; i < n; i++){
				char c = line.charAt(i);
				if('0' <= c && c <= '9'){
					int d = (c-'0')%3;
					if(i > 0){
						for(int j = 0; j < 3; j++){
							mods[(j+d)%3][i] = mods[j][i-1];
						}
					}
					mods[d][i]++;
					res += mods[0][i];
				}
				else{
					for(int j = 0; j < 3; j++) mods[j][i] = 0;
				}
			}
			System.out.println(res);
		}
	}

}
