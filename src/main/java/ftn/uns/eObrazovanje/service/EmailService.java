package ftn.uns.eObrazovanje.service;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {

	void sendmail(String email, String subjectName) throws AddressException, MessagingException;
}
