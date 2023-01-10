package com.email;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import jakarta.mail.Address;
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
class EmailApplicationTests {
	
	
	

	@Test
	public void testeEmail() {
		
		try {
			
			Properties props = new Properties();
		    /* Parâmetros de conexão com servidor Gmail */
		    
			props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.socketFactory.port", "465");
		    props.put("mail.smtp.socketFactory.class",
		    "javax.net.ssl.SSLSocketFactory");
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.port", "465");
		    
		    Session session = Session.getDefaultInstance(props,
		    	      new Authenticator() {
		    	           protected PasswordAuthentication getPasswordAuthentication()
		    	           {
		    	                 return new PasswordAuthentication("marcos.aurelio.dias13@gmail.com",
		    	                 "npuxjzjottfmniam");
		    	           }
		    	      });

		    
			System.out.println(session);
			
			
			Address[] toUser = InternetAddress.parse("mdstudio10@gmail.com"); /*destino */
			
			Message message = new MimeMessage(session);
		      message.setFrom(new InternetAddress("marcos.aurelio.dias13@gmail.com"));
		      
		      message.setRecipients(Message.RecipientType.TO, toUser);
		      message.setSubject("Teste marcos dias"); //Assunto
		      
		      message.setText("teste email gmail");
		     
		      /*Método para enviar a mensagem criada*/
		      Transport.send(message);

		      System.out.println("Feito!!!");
		    
		}catch(Exception e){
			
			e.printStackTrace();
		}
	
		
		
		
	}

}
