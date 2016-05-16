import java.util.*;
import java.io.*;
import java.math.*;
public class Bases {
	public static void main(String...thegame) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String line = br.readLine(); if(line.equals("=")) return;
			Expression tot = new Expression("0");
			Expression mult = new Expression("1");
			boolean sum = true;
			StringBuilder sb = new StringBuilder(); int max = 2;
			for(int i = 0; i < line.length(); i++){
				char c = line.charAt(i);
				if(c == '='){
					mult = mult.multiply(new Expression(sb.toString()));
					tot = tot.sum(mult);
					mult = new Expression("1");
					sb = new StringBuilder();
					sum = false;
				}
				else if(c == '+'){
					mult = mult.multiply(new Expression(sb.toString()));
					if(sum) tot = tot.sum(mult);
					else tot = tot.substract(mult);
					mult = new Expression("1");
					sb = new StringBuilder();
				}
				else if(c == '*'){
					mult = mult.multiply(new Expression(sb.toString()));
					sb = new StringBuilder();
				}
				else{
					sb.append(c);
					max = Math.max(max, c-'0'+1);
				}
			}
			mult = mult.multiply(new Expression(sb.toString()));
			tot = tot.substract(mult);
			if(tot.infiniteSolutions()) {
				System.out.println(max+"+"); continue;
			}
			sb = new StringBuilder();
			long a = Math.abs(tot.firstNonZeroCoef());
			ArrayList<Long> bases = new ArrayList<Long>();
			for(long d = 1; d*d <= a; d++){
				if(a%d==0){
					if(d >= max && tot.root(d)) bases.add(d);
					if((a/d)!= d && (a/d) >= max && tot.root(a/d)) bases.add(a/d);
				}
			}
			if(bases.size()==0) System.out.println("*");
			else{
				Collections.sort(bases);
				for(long b: bases) sb.append(b+" ");
				System.out.println(sb.toString().trim());
			}
		}
	}
	static class Expression{
		static final int N = 20;
		long[] coef = new long[N];
		public Expression(String s){
			for(int i = 0; i < s.length(); i++){
				coef[i] = s.charAt(s.length()-i-1) - '0';
			}
		}
		public Expression(long[] arr){
			this.coef = arr;
		}
		public Expression multiply(Expression e){
			long[] arr = new long[N];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N-i; j++){
					arr[i+j] += coef[i] * e.coef[j];
				}
			}
			return new Expression(arr);
		}
		public Expression sum(Expression e){
			long[] arr = new long[N];
			for(int i = 0; i < N; i++){
				arr[i] = coef[i] + e.coef[i];
			}
			return new Expression(arr);
		}
		public Expression substract(Expression e){
			long[] arr = new long[N];
			for(int i = 0; i < N; i++){
				arr[i] = coef[i] - e.coef[i];
			}
			return new Expression(arr);
		}
		public boolean root(long x){
			BigInteger res = BigInteger.ZERO; 
			BigInteger X = BigInteger.valueOf(x);
			for(int i = 0; i < N; i++){
				res = res.add(X.pow(i).multiply(BigInteger.valueOf(coef[i])));
			}
			return res.equals(BigInteger.ZERO);
		}
		public long firstNonZeroCoef(){
			for(long a: coef){
				if(a != 0) return a;
			}
			return 0;
		}
		public boolean infiniteSolutions(){
			for(long a: coef){
				if(a != 0) return false;
			}
			return true;
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++){
				sb.append(coef[i] + " ");
			}
			return sb.toString().trim();
		}
	}
}
