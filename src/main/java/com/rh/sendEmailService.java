package com.rh ;

import java.io.File;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class sendEmailService {

	@Autowired
	private JavaMailSender javaMailSender ;
	
	public void sendEmail(String from , String to , String body , String topic ) throws MessagingException {
		
		// send pdf file 
		
		//ClassPathResource pdf = new ClassPathResource("static/attachment.pdf");
		
		// File factue_pdf_to_send = new File("C://Users/dridi family/Downloads/facture.pdf");
		
		System.out.println("sending email ....") ;
		
		
		
		
		
		
		// test seul
		
		String path ="C://Users/dridi family/Downloads/facture.pdf";
		
		MimeMessage message = javaMailSender.createMimeMessage();
		
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        
        helper.setFrom(from);
        helper.setTo(to);
        helper.setText(body);
        
        FileSystemResource file  = new FileSystemResource(new File(path));
        
        helper.addAttachment("facture.pdf", file);
        
        helper.setSubject(topic);
        
        javaMailSender.send(message);
        
        // fin test seul
        
        /*
        
        SimpleMailMessage simpleMaiMessage = new SimpleMailMessage() ;
        
		simpleMaiMessage.setFrom(from);
		
		simpleMaiMessage.setTo(to);
		
		simpleMaiMessage.setSubject(topic);
		
		simpleMaiMessage.setText(body);
		
		
		javaMailSender.send(simpleMaiMessage);
		
		*/
		
		
		System.out.println("email sent :) ");
	}
	
	
	
	
	// send emila with attachement 'facture pdf file ' .
	
	

public void sendMailWithAttachment(String to, String subject, String body) {
    MimeMessagePreparator preparator = new MimeMessagePreparator() 
    {
      

		@Override
		public void prepare(MimeMessage mimeMessage) throws Exception {
			  mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	            mimeMessage.setFrom("mohammedamine.dridi.esprit@gmail.com");
	            mimeMessage.setSubject(subject);
	            mimeMessage.setText(body);
	             
	            /*
	            FileSystemResource file = new FileSystemResource(new File("C://Users/dridi family/Downloads/facture.pdf"));
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            helper.addAttachment("facture_test.pdf", file);
	            
	            */
	            
	            // test seul 
	            
	            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
	            
	            ClassPathResource  file_pdf = new ClassPathResource("C://Users/dridi family/Downloads/facture.pdf");
	            
	            File test_file = new File( file_pdf.getPath() );
	            
	            helper.addAttachment(test_file.getName(), test_file);
			
		}
    };
     
    try {
    	javaMailSender.send(preparator);
    }
    catch (MailException ex) {
        // simply log it and go on...
        System.err.println(ex.getMessage());
        System.out.println("error in mail ????");
    }
}
	
	
}
