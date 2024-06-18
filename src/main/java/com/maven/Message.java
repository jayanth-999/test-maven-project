package com.maven;

import java.util.logging.Logger;

public class Message {
	private static final String INFO = "This is the message to be displayed on home page.";
	
	public Message() { 
		// This constructor is intentionally empty. Nothing special is needed here. 
	}
	
	public String getMessage() {
		return Message.INFO;			
	}
	
	public static void main(String[] args) {
		Class<Object> cl = Object.class;
		Logger logger = Logger.getLogger(cl.getClass().getName());
		logger.info(Message.INFO);
	}
}
