package ftn.uns.eObrazovanje.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import ftn.uns.eObrazovanje.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService{

	@Override
	public void sendmail(String email, String subjectName) throws AddressException, MessagingException  {
		   Properties props = new Properties();
		   props.put("mail.smtp.auth", "true");
		   props.put("mail.smtp.starttls.enable", "true");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.port", "587");
		   
		   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		      protected PasswordAuthentication getPasswordAuthentication() {
		         return new PasswordAuthentication("nemanja12344@gmail.com", "humgfvznnmlduxpa");
		      }
		   });
		   Message msg = new MimeMessage(session);
		   msg.setFrom(new InternetAddress("nemanja12344@gmail.com", false));

		   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
		   msg.setSubject("Fakultet - Unos Ocena");
		   String content = "Profesor iz predmeta " + subjectName + " je uneo vasu ocenu. <a href='https://localhost:4200/home'>Sajt</a>'";
		   msg.setContent(content , "text/html");
		   msg.setSentDate(new Date());

		   Transport.send(msg);   {}
	}
}
