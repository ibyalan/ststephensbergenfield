package com.lemmanet.server;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHandler {

	
	public static String sendMail(String name,String email,String phone,String notes){
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "This is an enquiry regarding the parish hall from " + name + " phone: " + phone + " Notes: " + notes;
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("alanthekkekuttu@gmail.com", "St Stephens Parish Hall"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("jobyvjohn@hotmail.com", "Mr. Joby John"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("vtkurian@yahoo.com", "Mr. Benison George"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("alanthekkekuttu@gmail.com", "Mr. Alan Varghese"));
            msg.addRecipient(Message.RecipientType.TO,
                    new InternetAddress("swvarghese@msn.com", "Mr. Sunny Varghese"));
            msg.setSubject("Parish Hall Request");
            msg.setText(msgBody);
            Transport.send(msg);

        } catch (Exception e) {
			e.printStackTrace();
	        return "Your message could not be send due to technical difficulties.";
		}
        
        return "Your message has been send succesfully.";
	}
}
