import java.util.*;
import java.io.*;
public class ASCIIAddition {
	static final String chars = "0123456789+";
	static String[] code;
	static final String[] training = 
		{	"xxxxx ....x xxxxx xxxxx x...x xxxxx xxxxx xxxxx xxxxx xxxxx .....",
			"x...x ....x ....x ....x x...x x.... x.... ....x x...x x...x ..x..",
			"x...x ....x ....x ....x x...x x.... x.... ....x x...x x...x ..x..",
			"x...x ....x xxxxx xxxxx xxxxx xxxxx xxxxx ....x xxxxx xxxxx xxxxx",
			"x...x ....x x.... ....x ....x ....x x...x ....x x...x ....x ..x..",
			"x...x ....x x.... ....x ....x ....x x...x ....x x...x ....x ..x..",
			"xxxxx ....x xxxxx xxxxx ....x xxxxx xxxxx ....x xxxxx xxxxx ....."};
	public static void main(String...thegame) throws Exception{
		StringBuilder[] sb = new StringBuilder[11];
		for(int j = 0; j < 11; j++){
			sb[j] = new StringBuilder();
		}
		for(int i = 0; i < 7; i++){
			String[] st = training[i].split(" ");
			for(int j = 0; j < 11; j++){
				sb[j].append(st[j]+" ");
			}
		}
		code = new String[11];
		for(int i = 0; i < 11; i++){
			code[i] = sb[i].toString();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line == null) return;
			int n = (line.length()+1)/6;
			sb = new StringBuilder[n];
			for(int i = 0; i < n; i++) sb[i] = new StringBuilder();
			for(int i = 0; i < 7; i++){
				if(i > 0) line = br.readLine();
				for(int j = 0; j < n; j++){
					sb[j].append(line.substring(6*j, 6*j+5)+" ");
				}
			}
			StringBuilder sb1 = new StringBuilder();
			for(int i = 0; i < n; i++){
				sb1.append(decode(sb[i].toString()));
			}
			String[] innums = sb1.toString().split("\\+");
			int a = Integer.parseInt(innums[0]);
			int b = Integer.parseInt(innums[1]);
			int c = a+b;
			System.out.println(code(c));
		}
	}
	static char decode(String s){
		for(int i = 0; i < 11; i++){
			if(code[i].equals(s)) return chars.charAt(i);
		}
		return 0;
	}
	static String code(int k){
		int n = (int)Math.log10(k)+1;
		StringBuilder[] sb = new StringBuilder[7];
		for(int i = 0; i < 7; i++) sb[i] = new StringBuilder();
		while(k > 0){
			String[] lines = code[k%10].split(" ");
			for(int i = 0; i < 7; i++){
				sb[i].replace(0,0,lines[i]+" ");
			}
			k/=10;
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0; i < 7; i++){
			res.append(sb[i].toString().trim().replaceAll(" ", ".")+" ");
		}
		return res.toString().trim().replaceAll(" ", "\n");
	}
}
