import java.io.*;
import java.util.*;
public class FlowersFlourish {
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line.equals("*")) return;
			line = line.toLowerCase(); char c = line.charAt(0);
			StringTokenizer st = new StringTokenizer(line);
			boolean res = true;
			while(st.hasMoreTokens()){
				res &= st.nextToken().charAt(0) == c;
			}
			System.out.println(res ? "Y":"N");
		}
	}
}
