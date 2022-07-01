import java.util.*;
public class TestGenerator {

	public static void main(String[] args) {
		Random r = new Random();
		int N = 500;
		int k = 8;
		for(int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < k; j++) {
				char c = (char)('a' + r.nextInt(26));
				sb.append(c);
			}
			System.out.println("r "+sb.toString());
		}
	}

}
