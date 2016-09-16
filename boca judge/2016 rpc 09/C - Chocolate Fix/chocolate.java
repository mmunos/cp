import java.util.*;
import java.io.*;
public class chocolate {
	static final int[][] deltas = {
			{0,2,4,6,8,10,12,14,16},
			{0,2,  6,8	 ,12,14	  },
			{0,    6,     12      },
			{0,2,4,6,8,10         },
			{0,2,  6,8            },
			{0,    6              },
			{0,2,4                },
			{0,2                  },
			{0                    }
	};
	static Clue[] clues;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test = 1; test <= T; test++){
			int n = Integer.parseInt(br.readLine());
			clues = new Clue[n];
			for(int cl = 0; cl < n; cl++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				String[] lines = new String[x];
				for(int i = 0; i < x; i++){
					st = new StringTokenizer(br.readLine());
					StringBuilder sb = new StringBuilder();
					while(st.hasMoreTokens()){
						sb.append(st.nextToken());
					}
					lines[i] = sb.toString();
				}
				clues[cl] = new Clue(x,y,lines);
			}
			
			System.out.printf("Puzzle #%d:\n",test);
			char[] combi = convert(find(9,0,""));
			for(int i = 0; i < 3; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < 3; j++){
					sb.append(combi[(i*3+j)*2]);
					sb.append(combi[(i*3+j)*2+1]);
					sb.append(' ');
				}
				System.out.println(sb.toString().trim());
			}
		}
	}
	static char[] convert(String s){
		char[] res = new char[18];
		Arrays.fill(res, '_');
		for(int i = 0; i < s.length(); i++){
			int val = s.charAt(i)-'0';
			res[2*i] = shape.charAt(val/3);
			res[2*i+1] = flavor.charAt(val%3);
		}
		return res;
	}
	static String find(int n, int k, String s){
		char[] map = convert(s);
		if(n == k){
			for(Clue cl: clues){
				if(!cl.match(map)) return null;
			}
			return s;
		}
		else{
			for(Clue cl: clues){
				if(!cl.match(map)) return null;
			}
			for(int i = 0; i < n; i++){
				if(!s.contains(""+i)){
					String res = find(n,k+1,s+i);
					if(res != null) return res;
				}
			}
			return null;
		}
	}
	static final String shape = "SRT";
	static final String flavor = "VSC";
	static class Clue{
		int x, y;
		char[] letters = new char[18];
		public Clue(int x, int y, String[] lines){
			Arrays.fill(letters, '_');
			this.x = x; this.y = y;
			for(int i = 0; i < x; i++){
				for(int j = 0; j < lines[i].length(); j++){
					char c = lines[i].charAt(j);
					letters[i*6 + j] = c;
				}
			}
		}
		boolean match(char[] map){ //sol is a string length 9 with numbers 0 trough 8
			int[] dss = deltas[3*(x-1)+(y-1)];
			for(int d: dss){
				boolean match = true;
				for(int i = 0; i+d < 18; i++){
					if(map[i+d] != '_' && letters[i] != '_' && 
							letters[i] != map[i+d]) match = false;
				}
				if(match) return true;
			}
			return false;
		}
	}

}
