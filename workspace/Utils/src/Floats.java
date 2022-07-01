import java.math.*;
import java.util.*;
public class Floats {

	public static void main(String[] args) {
		int intx = Integer.MAX_VALUE+1;
		System.out.println("rep: "+toString(intx));
		System.out.println("val: "+Float.intBitsToFloat(intx));
		System.out.println("rep: "+toString(0));
		System.out.println("val: "+Float.intBitsToFloat(0));
		
//		float what2 = 16777216;
//		int whot = Float.floatToRawIntBits(what2);
//		System.out.println(toString(whot));
		
//		float x = 0;
//		for(int i = 0; i < 30; i++) {
//			int a = (1 << i) -1;
//			System.out.println(a+":");
//			int y = Float.floatToRawIntBits(a);
//			System.out.println(toIEEE754_1985(y));
//		}
//		System.out.println();
	}
	static String toString(int y) {
		return pad(Integer.toBinaryString(y), 32);
	}
	static String pad(String s, int size) {
		return String.format("%32s",s).replace(' ','0');
	}

}
