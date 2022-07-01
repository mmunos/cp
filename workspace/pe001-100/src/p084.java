import java.util.*;
public class p084 {
	
	static String[] labels = { "GO", "A1", "CC1", "A2", "T1", "R1", "B1", "CH1", "B2", "B3",
			"JAIL", "C1", "U1", "C2", "C3", "R2", "D1", "CC2", "D2", "D3",
			"FP", "E1", "CH2", "E2", "E3", "R3", "F1", "F2", "U2", "F3",
			"G2J", "G1", "G2", "CC3", "G3", "R4", "CH3", "H1", "T2", "H2" };
	static TreeMap<String, Integer> pos;
	static int n;
	public static void main(String[] args) {
		pos = new TreeMap<>();
		n = labels.length;
		for(int i = 0; i < n; i++) {
			pos.put(labels[i], i);
		}
		int[] ccs = {2, 17, 33};
		cc = new boolean[n];
		for(int k: ccs) cc[k] = true;
		int[] chs = {7, 22, 36};
		ch = new boolean[n];
		for(int k: chs) ch[k] = true;
		int[] rs = {5, 15, 25, 35};
		r = new boolean[n];
		for(int k: rs) r[k] = true;
		int[] us = {12, 28};
		u = new boolean[n];
		for(int k: us) u[k] = true;
		
		simul(10000000, 4);
		
	}
	static void simul(int N, int D){
		Random r = new Random();
		ArrayList<Integer> cccards = new ArrayList<>();
		ArrayList<Integer> chcards = new ArrayList<>();
		for(int i = 0; i < 16; i++) {
			cccards.add(i);
			chcards.add(i);
		}
		Collections.shuffle(cccards);
		Collections.shuffle(chcards);
		int ccind = 0, chind = 0;
		int[] count = new int[n];
		int p = 0;
		for(int turn = 0; turn < N; turn++) {
			int ceq = 0;
			while(true) {
				int d1 = r.nextInt(D) + 1;
				int d2 = r.nextInt(D) + 1;
				if(d1 == d2) ceq++;
				if(ceq == 3) {
					p = 10; break;
				}
				else {
					p = (p + d1 + d2) % n;
					while(cc[p] || ch[p]) {
						if(cc[p]) {
							int pp = calccc(p, cccards.get(ccind)); ccind = (ccind + 1) % 16;
							if(pp == p) break;
							else p = pp;
						}
						else if(ch[p]) {
							int pp = calcch(p, chcards.get(chind)); chind = (chind + 1) % 16;
							if(pp == p) break;
							else p = pp;
						}
					}
					if(d1 != d2) break;
				}
			}
			if(p == 30) p = 10;
			count[p]++;
		}
		for(int i = 0; i < n; i++) {
			System.out.printf("%s: %f\n", labels[i], count[i]*1.0/N);
		}
	}
	static boolean[] cc, ch, r, u;
	static int calcch(int p, int v) {
		if(v == 0) { // Advance to GO
			return 0;
		}
		else if(v == 1) { // Go to JAIL
			return 10;
		}
		else if(v == 2) { // Go to C1
			return 11;
		}
		else if(v == 3) { // Go to E3
			return 24;
		}
		else if(v == 4) { // Go to H2
			return 39;
		}
		else if(v == 5) { // Go to R1
			return 5;
		}
		else if(v == 6 || v == 7) { // Go to next R (railway company)
			while(!r[p]) p = (p + 1) % n;
			return p;
		}
		else if(v == 8) { // Go to next U (utility company)
			while(!u[p]) p = (p + 1) % n;
			return p;
		}
		else if(v == 9) { // Go back 3 squares
			return (p - 3 + n) % n;
		}
		else return p;
	}
	static int calccc(int p, int v) {
		if(v == 0) { // Advance to GO
			return 0; 
		}
		else if(v == 1) { // Go to JAIL
			return 10;
		}
		else return p;
	}

}
