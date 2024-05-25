package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
//sbien1212@gmail.com ; fwze cxzk bdyt miyj
//ltlc29113@gmail password="wbqu luqa dbhn xdso";
	static final String from="sbien1212@gmail.com";
	static final String password="fwze cxzk bdyt miyj";	
		
	
	public static boolean sendEmail( String to,String tieuDe,String noiDung) {
		//char[] chars=password.toCharArray();
				//properties: khai bao cac thuoc tinh
				Properties properties = new Properties();
				properties.put("mail.smtp.host", "smtp.gmail.com");//SMTP Host
				properties.put("mail.smtp.port", "587");//TLS 587 SSL 465
				properties.put("mail.smtp.auth", "true");//
				properties.put("mail.smtp.starttls.enable", "true");//SMTP Host
				//create authenticator
				Authenticator authenticator = new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(from, password);
					}
						
				};
				//phien lam viec-javax.mail
				Session session=Session.getInstance(properties,authenticator);
				//gui email
				MimeMessage message = new MimeMessage(session);
				try {
					message.addHeader("Content-type", "text/HTML; charset=UTF-8");
					//nguoi gui
					message.setFrom(from);
					//nguoi nhan
					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
					//tieu de
					message.setSubject(tieuDe);
					//quy dinh ngay gui
					message.setSentDate(new Date());
					//quy dinh email nhan phan hoi
					//InternetAddress.parse(from, false)
					
					//noi dung
					message.setContent(noiDung,"text/html;charset=UTF-8");//text/html
					//gui email
					Transport.send(message);
					System.out.println("Send email success");
					return true;
					
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Send email false ");
					return false;

				}
	
			}
	public static void main(String[] args) {
		String to="ltlc29113@gmail.com";
		String noiDung="Tương lai tao sẽ khátttt!";
		String tieuDe="Test";
		for (int i = 0; i < 5; i++) {
			Email.sendEmail(to, tieuDe, noiDung);

		}
	}
	
}
	
		

