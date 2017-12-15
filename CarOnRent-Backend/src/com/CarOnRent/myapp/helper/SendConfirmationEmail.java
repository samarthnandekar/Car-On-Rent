package com.CarOnRent.myapp.helper;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class SendConfirmationEmail {

	public static boolean sendMail(String receiveEmailId, String receiverMessage) {

		boolean check = true;
		System.out.println("inside mail sent");
		String from = "samarth1282015@gmail.com";
		String password = "sairforce";
		String host = "smtp.gmail.com";
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(props, null);
		MimeMessage mimeMessage = new MimeMessage(session);
		try {
			mimeMessage.setFrom(new InternetAddress(from));
			InternetAddress ia = new InternetAddress(receiveEmailId);
			mimeMessage.addRecipient(Message.RecipientType.TO, ia);
			mimeMessage.setSubject("CarOnRent:Please find login deetails");
			mimeMessage.setText(receiverMessage);
			Transport transport = session.getTransport("smtp");
			transport.connect(host, from, password);
			transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
			transport.close();
			return true;
		} catch (Exception me) {
			me.printStackTrace();
			check = false;
			return false;
		} finally {
			if (check == false) {
				JOptionPane
						.showMessageDialog(null,
								"ERROR! Please make sure you have entered valide Email-ID");
			}
		}

	}

}
