import java.util.*;
import java.io.*;
public class countingsubsthreengs {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) break;
			long[] mods = new long[3];
			char[] s = line.toCharArray();
			long res = 0;
			for(char c: s){
				if('0' <= c && c <= '9'){
					int d = (c-'0')%3;
					long[] newmods = new long[3];
					for(int i = 0; i < 3; i++){
						newmods[(i+d)%3] = mods[i];
					}
					newmods[d]++;
					res += newmods[0];
					mods = newmods;
				}
				else{
					mods = new long[3];
				}
			}
			System.out.println(res);
		}
	}

}
