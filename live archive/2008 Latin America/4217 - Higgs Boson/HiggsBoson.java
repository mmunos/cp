import java.util.*;
public class HiggsBoson {
	public static void main(String...thegame) throws Exception{
		Scanner seer = new Scanner(System.in);
		while(true){
			boolean fin = true;
			int[] a = new int[4]; int[] b = new int[4];
			for(int i = 0; i < 4; i++){
				a[i] = seer.nextInt();
				if(a[i]!=0) fin = false;
			}
			for(int i = 0; i < 4; i++){
				b[i] = seer.nextInt();
				if(b[i]!=0) fin = false;
			}
			if(fin) return;
			
			ArrayList<Fraction> poss_fr = new ArrayList<>();
			
			//t1: r_a = r_b
			Fraction t1 = new Fraction(b[1]-a[1],a[0]-b[0]);
			if(t1.a == 0 && t1.b == 0){ //radiuses are always equal
				Fraction t11 = new Fraction(b[3] - a[3],a[2] - b[2]);
				t11.a %= 360; t11.a += 360; t11.a %= 360;
				if(t11.a == 0 && t11.b == 0){ //particles are always touching
					poss_fr.add(new Fraction(0,1));
				}
				else if(t11.b > 0){	//b if not positive is zero and then particles never touch
									//(unless they reach (r = 0) but that's another case)
					poss_fr.add(t11);
				}
				
				//r = 0
				Fraction t12 = new Fraction(-a[1],a[0]);
				if(t12.a >= 0){
					poss_fr.add(t12);
				}
			}
			else if(t1.a >= 0 && t1.b > 0){	//a must be non-negative because we look for positive t's
											//b if not positive is zero and then radiuses never touch
				if(t1.turnsToInt(a[2]-b[2]) && (t1.multiply(a[2]-b[2])-b[3]+a[3]) % 360 == 0){
					poss_fr.add(t1);
				}
				
				//r = 0
				if(t1.turnsToInt(a[0]) && t1.multiply(a[0])+a[1]==0){
					poss_fr.add(t1);
				}
			}
			
			//t1: r_a = r_b
			Fraction t2 = new Fraction(-(a[1]+b[1]),a[0]+b[0]);
			if(t2.a == 0 && t2.b == 0){ //radiuses are always equal
				Fraction t21 = new Fraction(b[3] - a[3] + 180,a[2] - b[2]);
				t21.a %= 360; t21.a += 360; t21.a %= 360;
				if(t21.a == 0 && t21.b == 0){ //particles are always touching
					poss_fr.add(new Fraction(0,1));
				}
				else if(t21.b > 0){	//b if not positive is zero and then particles never touch
									//(unless they reach (r = 0) but that's another case)
					poss_fr.add(t21);
				}
				
				//r = 0
				Fraction t22 = new Fraction(-a[1],a[0]);
				if(t22.a >= 0){
					poss_fr.add(t22);
				}
			}
			else if(t2.a >= 0 && t2.b > 0){	//a must be non-negative because we look for positive t's
											//b if not positive is zero and then radiuses never touch
				if(t2.turnsToInt(a[2]-b[2]) && (t2.multiply(a[2]-b[2])-b[3]+a[3] - 180) % 360 == 0){
					poss_fr.add(t2);
				}
				
				//r = 0
				if(t2.turnsToInt(a[0]) && t2.multiply(a[0])+a[1]==0){
					poss_fr.add(t2);
				}
			}
			
			Collections.sort(poss_fr);
			if(poss_fr.size() == 0) System.out.println("0 0");
			else {
				Fraction res = poss_fr.get(0);
				res.simplify();
				System.out.println(res);
			}
		}
	}
	static class Fraction implements Comparable<Fraction>{
		int a, b; boolean valid = false;
		public Fraction(int a, int b){
			if(b == 0 && a == 0) return;
			else if(b == 0){this.a = 1;}
			else if(a == 0){this.b = 1;}
			else{
				int sign = (a < 0 && b > 0) || (a > 0 && b < 0) ? -1 : 1;
				this.a = sign*Math.abs(a); 
				this.b = Math.abs(b);
			}
		}
		public int compareTo(Fraction o){
			return a*o.b - b*o.a;
		}
		public boolean turnsToInt(int c){
			simplify();
			return c%b==0;
		}
		public int multiply(int c){
			return a*c/b;
		}
		public void simplify(){
			int c = mcd(a,b);
			a /= c; b /= c;
		}
		int mcd(int a, int b){
			if(b == 0) return a;
			else return mcd(b, a%b);
		}
		public String toString(){
			return a+" "+b;
		}
	}
}
