import java.util.*;
import java.io.*;
public class IO {

	public static void main(String[] args) throws Exception {
		FastScanner sc = new FastScanner();
		//in
		int T = sc.nextInt();
		while(T-- > 0) {
			
		//out
		ArrayList<Integer> res = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int _r: res) {
			sb.append(_r+" ");
		}
		bw.write(sb.toString().trim());
		bw.write("\n");
		bw.flush();
		}
	}
	static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
        	return Long.parseLong(next());
        }
        public double nextDouble() {
        	return Double.parseDouble(next());
        }
        public String nextLine() {
        	try {
        		return reader.readLine();
        	} catch(IOException e) {
        		throw new RuntimeException(e);
        	}
        }
    }

}
