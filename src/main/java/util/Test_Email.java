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


public class Test_Email {

//
	public static void sendEmail(String to,String noiDung) {
		
	}
	public static void main(String[] args) {
		final String from="sbien1212@gmail.com";
		final String password="xxxx xxxx xxxx xxxx";
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
		final String to ="transongbien129@gmail.com";//to cc bcc in email
		//tao mot tin nhan
		MimeMessage message = new MimeMessage(session);
		try {
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			//nguoi gui
			message.setFrom(from);
			//nguoi nhan
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
			//tieu de
			message.setSubject("Test send email");
			//quy dinh ngay gui
			message.setSentDate(new Date());
			//quy dinh email nhan phan hoi
			//InternetAddress.parse(from, false)
			
			//noi dung
			message.setText("Hello word, today me no happy but me will try","UTF-8");
			//gui email
			Transport.send(message);
			System.out.println("Send email success");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Send email false ");

		}

		
	}

}
