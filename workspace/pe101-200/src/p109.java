import java.util.*;
public class p109 {
	
	static String[] scores = {
			"D1", "D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "D11", "D12", "D13", "D14", "D15", "D16", "D17", "D18", "D19", "D20", "D25",
			"S1", "S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "S11", "S12", "S13", "S14", "S15", "S16", "S17", "S18", "S19", "S20", "S25",
			"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12", "T13", "T14", "T15", "T16", "T17", "T18", "T19", "T20", ""
	};

	public static void main(String[] args) {
		int m = scores.length;
		int count = 0;
		for(int i = 0; i < m; i++) {
			for(int j = i; j < m; j++) {
				for(int k = 0; k < 21; k++) {
					int sc = parse(scores[i]) + parse(scores[j]) + parse(scores[k]);
					if(sc < 100) count++;
				}
			}
		}
		System.out.println(count);
	}
	static int parse(String s) {
		if(s.isEmpty()) return 0;
		int v = Integer.parseInt(s.substring(1));
		if(s.charAt(0) == 'S') return v;
		if(s.charAt(0) == 'D') return 2*v;
		else return 3*v;
	}

}
