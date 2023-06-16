package it.sincrono.services.utils;
import java.util.Base64;
import java.security.SecureRandom;


public class KeyGenerator {
	
	 public String keyGenerator(){
		 
	    byte[] key = new byte[32];
	    SecureRandom secureRandom = new SecureRandom();
	    secureRandom.nextBytes(key);
	    String base64Key = Base64.getEncoder().encodeToString(key);
	    return base64Key;
	    }

}
