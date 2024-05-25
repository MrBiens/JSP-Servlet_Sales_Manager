package util;

import java.util.Random;

public class MaXacThuc {
	public static String maXacThuc() {
		Random rdRandom = new Random();
//		String s1= rdRandom.nextInt(1000000)+"";
//		int ep1 = Integer.parseInt(s1);
//		
//		String s2="";
//		int ep2=0;
//		
//		while (ep1 > 100000 ) {
//			s2= rdRandom.nextInt(1000000)+"";
//			ep2 = Integer.parseInt(s2);
//			ep1=ep2;
//			
//			
//		}
//		System.out.println(ep1);
		
		String s1= rdRandom.nextInt(10)+"";
		String s2= rdRandom.nextInt(10)+"";
		String s3= rdRandom.nextInt(10)+"";
		String s4= rdRandom.nextInt(10)+"";
		String s5= rdRandom.nextInt(10)+"";
		String s6= rdRandom.nextInt(10)+"";
		
		String s = s1+s2+s3+s4+s5+s6;
		return s;
	}
//	public static void main(String[] args) {
//		MaHoa maHoa = new MaHoa();
//		String s= maXacThuc();
//		s =maHoa.toSHA256(s);
//		System.out.println(s);
//		
//	}
	
}
