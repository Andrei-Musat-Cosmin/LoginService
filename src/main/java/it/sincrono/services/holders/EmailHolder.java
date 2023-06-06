package it.sincrono.services.holders;

import java.util.*;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.sincrono.repositories.entities.Anagrafica;



@Component
public class EmailHolder extends BaseHolder {


	public void sendMail(Anagrafica anagrafica, String token) throws Exception {

		/*HashMap<String, String> configurazioni = new HashMap<>();

	
		}

		String server, port, username, password, subject, auth, tls, body, protocols;

		server = configurazioni.get("mail.smtp.host");
		port = configurazioni.get("mail.smtp.port");
		username = configurazioni.get("mail.smtp.username");
		password = configurazioni.get("mail.smtp.password");
		subject = configurazioni.get("mail.smtp.email.subject");
		auth = configurazioni.get("mail.smtp.auth");
		tls = configurazioni.get("mail.smtp.email.tls");
		body = configurazioni.get("mail.smtp.email.first.access");
		protocols = configurazioni.get("mail.smtp.ssl.protocols");
		
		body = body.replace("{0}", anagrafica.getNome()).replace("{1}", anagrafica.getCognome()).replace("{2}", token);

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", server);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", auth);
		properties.put("mail.smtp.starttls.enable", tls);
		properties.put("mail.smtp.ssl.trust", server);
		properties.put("mail.smtp.ssl.protocols", protocols);

		Session session = Session.getDefaultInstance(properties);

		try {
			Message msg = new MimeMessage(session);
			InternetAddress[] toAddresses = { new InternetAddress(anagrafica.getEmail()) };

			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			msg.setSubject(subject);
			msg.setSentDate(new Date());
			msg.setText(body + token);

			Transport t = session.getTransport("smtp");

			t.connect(username, password);
			t.sendMessage(msg, msg.getAllRecipients());
			t.close();

		} catch (MessagingException e) {
			throw e;
		}*/
	}
}
	