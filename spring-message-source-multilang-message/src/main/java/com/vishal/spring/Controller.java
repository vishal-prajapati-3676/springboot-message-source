package com.vishal.spring;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private static final String MESSAGE_HELLO = "message.hello";

	@Autowired
    private MessageSource messageSource;
	
	@Value("${application.active.language}")
	String activeLanguage;
	
	@GetMapping("/getActiveLanguageMessage")
	public String getActiveLanguageMessage() {
		return messageSource.getMessage(MESSAGE_HELLO,null, getActiveLanguage());
	} 
	
	public Locale getActiveLanguage() {
		if(activeLanguage.equals("english"))
			return new Locale("en","US");
		else 
			return new Locale("es", ""); 
	}
	
}
