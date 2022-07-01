import java.util.*;
import java.io.*;
public class Geometry { //based on TheInheritance
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int test = 0; test < T; test++){
			br.readLine();
			ArrayList<Point> F = new ArrayList<>(); //father's polygon
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			while(st.hasMoreTokens()){
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				F.add(new Point(x,y));
			}
			F.add(F.get(0));
			int n = Integer.parseInt(br.readLine().trim());
			Pair[] walls = new Pair[n];
			HashSet<Point> points = new HashSet<>();
			boolean steal = false;
			for(int i = 0; i < n; i++){
				st = new StringTokenizer(br.readLine().trim());
				int x1 = Integer.parseInt(st.nextToken());
				int y1 = Integer.parseInt(st.nextToken());
				int x2 = Integer.parseInt(st.nextToken());
				int y2 = Integer.parseInt(st.nextToken());
				Point a = new Point(x1,y1);
				Point b = new Point(x2,y2);
				if(!inPolygon(a, F) || !inPolygon(b, F)) steal = true;
				walls[i] = new Pair(a, b);
				points.add(a); points.add(b);
			}
			if(steal){
				System.out.println("Trying to steal neighbors' land");
				if(test<T-1)System.out.println(""); continue;
			}
			ArrayList<Point> S = new ArrayList<>(); //son's polygon
			S.add(walls[0].a); S.add(walls[0].b); boolean open = false;
			for(int i = 1; i < points.size(); i++){
				Point pp = S.get(i-1);
				Point p = S.get(i);
				boolean neigh = false;
				for(Pair q: walls){
					if(q.a.equals(p) && !q.b.equals(pp)){
						S.add(q.b); neigh = true;
					}
					else if(q.b.equals(p) && !q.a.equals(pp)){
						S.add(q.a); neigh = true;
					}
				}
				if(!neigh) {
					open = true; break;
				}
			}
			double areaF = area(F);
			double areaS = area(S);
			if(areaS < 1e-7 || open) System.out.println("Sorry, your assignment do not deserve an inheritance");
			else {
				StringBuilder sb = new StringBuilder();
				for(int i = 0; i < S.size()-1; i++){
					sb.append(S.get(i)+" ");
				}
				System.out.printf("The area free for your father is: %.3f and your land is: %s\n",areaF-areaS,sb.toString().trim());
			}
			if(test<T-1)System.out.println("");
		}
	}
	static double dist(Point a, Point b) {
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	static double dot(Point a, Point b){
		return a.x * b.x + a.y * b.y;
	}
	static double norm_sq(Point a){
		return a.x * a.x + a.y * a.y;
	}
	static Point toVec(Point a, Point b){
		return new Point(a.x-b.x,a.y-b.y);
	}
	static double angle(Point a, Point o, Point b){ // return angle aob in rad
		Point oa = toVec(o,a); Point ob = toVec(o,b);
		return Math.acos(dot(oa,ob) / Math.sqrt(norm_sq(oa) * norm_sq(ob)));
	}
	static double cross(Point a, Point b){
		return a.x * b.y - a.y * b.x;
	}
	static boolean ccw(Point p, Point q, Point r){
		return cross(toVec(p,q),toVec(p,r))>0;
	}
	static double area(ArrayList<Point> P){
		double res = 0, x1, y1, x2, y2;
		for(int i = 0; i < P.size()-1; i++){
			x1 = P.get(i).x; x2 = P.get(i+1).x;
			y1 = P.get(i).y; y2 = P.get(i+1).y;
			res += (x1*y2 - x2*y1);
		}
		return Math.abs(res)/2.0;
	}
	static boolean inPolygon(Point pt, ArrayList<Point> P){
		if(P.size()==0) return false;
		double sum = 0;
		for(int i = 0; i < P.size()-1; i++){
			double ang = angle(P.get(i),pt,P.get(i+1));
			if(Math.abs(ang - Math.PI) < 1e-7) return false;
			if(ccw(pt,P.get(i),P.get(i+1))){
				sum += ang;
			}
			else{
				sum -= ang;
			}
		}
		return Math.abs(Math.abs(sum) - 2*Math.PI) < 1e-7;
	}
	static class Point{
		double x; double y;
		public Point(double _x, double _y){
			x = _x; y = _y;
		}
		@Override
		public boolean equals(Object p){
			if(p == null) return false;
			if (!Point.class.isAssignableFrom(p.getClass())) {
		        return false;
		    }
			Point q = (Point) p;
			return x == q.x && y == q.y;
		}
		@Override
		public int hashCode() {
		    return (int)(x+y);
		}
		@Override
		public String toString() {
			return (int)x+" "+(int)y;
		}
	}
	static class Pair{
		Point a; Point b;
		public Pair(Point _a, Point _b){
			a = _a; b = _b;
		}
	}
}
