import java.util.*;
public class HoveringHornet {
	public static void main(String...thegame) {
		Scanner seer = new Scanner(System.in);
		while(seer.hasNext()){
			Point[] vs = new Point[4]; int upleft = 3;
			for(int i = 3; i >= 0; i--){
				vs[i] = new Point(seer.nextDouble(), seer.nextDouble());
				if(vs[i].x < vs[upleft].x ||
						(vs[i].x == vs[upleft].x && vs[i].y > vs[upleft].y)){
					upleft = i;
				}
			}
			Point[] realvs = new Point[4];
			for(int i = 0; i < 4; i++){
				realvs[i] = vs[(i+upleft)%4];
			}
			vs = realvs;
			//up - 6
			ArrayList<Point> p6 = new ArrayList<>();
			if(vs[0].y <= 0.5){
				p6.add(meety(vs[0],vs[1],0.5));
			}
			else{
				p6.add(meety(vs[3],vs[0],0.5));
				p6.add(vs[0]);
			}
			p6.add(vs[1]);
			if(vs[2].y <= 0.5){
				p6.add(meety(vs[1],vs[2],0.5));
			}
			else{
				p6.add(vs[2]);
				p6.add(meety(vs[2],vs[3],0.5));
			}
			//right - 3
			ArrayList<Point> p3 = new ArrayList<>();
			if(vs[1].x <= 0.5){
				p3.add(meetx(vs[1],vs[2],0.5));
			}
			else{
				p3.add(meetx(vs[0],vs[1],0.5));
				p3.add(vs[1]);
			}
			p3.add(vs[2]);
			if(vs[3].x <= 0.5){
				p3.add(meetx(vs[2],vs[3],0.5));
			}
			else{
				p3.add(vs[3]);
				p3.add(meetx(vs[3],vs[0],0.5));
			}
			//down - 1
			ArrayList<Point> p1 = new ArrayList<>();
			if(vs[2].y >= -0.5){
				p1.add(meety(vs[2],vs[3],-0.5));
			}
			else{
				p1.add(meety(vs[1],vs[2],-0.5));
				p1.add(vs[2]);
			}
			p1.add(vs[3]);
			if(vs[0].y >= -0.5){
				p1.add(meety(vs[0],vs[3],-0.5));
			}
			else{
				p1.add(vs[0]);
				p1.add(meety(vs[0],vs[1],-0.5));
			}
			//left - 4
			ArrayList<Point> p4 = new ArrayList<>();
			if(vs[3].x >= -0.5){
				p4.add(meetx(vs[3],vs[0],-0.5));
			}
			else{
				p4.add(meetx(vs[2],vs[3],-0.5));
				p4.add(vs[3]);
			}
			p4.add(vs[0]);
			if(vs[1].x >= -0.5){
				p4.add(meetx(vs[0],vs[1],-0.5));
			}
			else{
				p4.add(vs[1]);
				p4.add(meetx(vs[1],vs[2],-0.5));
			}
			double A1 = area(p1);
			double A3 = area(p3);
			double A4 = area(p4);
			double A6 = area(p6);
			System.out.println((6*5*A6 + 3*5*A3 + 1*5*A1 + 4*5*A4 + 5*5*5*4)/(5*5*5-1*1*1));
		}
	}
	static double area(ArrayList<Point> ps){
		while(ps.contains(null)){
			ps.remove(null);
		}
		double res = 0; int n = ps.size();
		for(int i = 0; i < n; i++){
			res += ps.get(i).x * ps.get((i+1)%n).y;
			res -= ps.get(i).y * ps.get((i+1)%n).x;
		}
		return Math.abs(res/2);
	}
	static Point meetx(Point a, Point b, double x){
		if(a.x == b.x) return null;
		double c = (b.y*a.x - b.x*a.y)/(a.x - b.x);
		double y = (a.y - b.y)/(a.x - b.x) * x + c;
		return new Point(x, y);
	}
	static Point meety(Point a, Point b, double y){
		if(a.y == b.y) return null;
		double c = (b.x*a.y - b.y*a.x)/(a.y - b.y);
		double x = (a.x - b.x)/(a.y - b.y) * y + c;
		return new Point(x, y);
	}
	static class Point {
		double x, y;
		public Point(double x, double y){
			this.x = x; this.y = y;
		}
		public String toString(){
			return x+" "+y;
		}
	}

}
