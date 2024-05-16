package util;

import java.security.MessageDigest;
import org.apache.tomcat.util.codec.binary.Base64;

public class MaHoa {
	
	public static String toSHA256(String str) {
		String salt="skjdhfwkwiufhwiu12oi4u1;";
		String result=null;
		
		str =str+salt;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
			result=Base64.encodeBase64String(messageDigest.digest(dataBytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println("Truoc khi ma hoa SHA-1:"+"123");
		System.out.println("Sau khi duoc ma hoa:"+toSHA256("123"));
	}
}
