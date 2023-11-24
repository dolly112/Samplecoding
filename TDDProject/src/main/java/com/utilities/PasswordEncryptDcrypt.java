package com.utilities;

import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;

/**
 * This class for Encrypt and Decrypt the password
 * 1) this class has to run for the 1st time generate the encrypted password and has to run whenever password changed
 *  Copy the encrypted password and paste it in the property File i.e UserPwd
 * @author GRANDIS
 *
 */
public class PasswordEncryptDcrypt {
	public static Logger LOGGER = Logger.getLogger(PasswordEncryptDcrypt.class);

     
    /**
     * @author GRANDIS
     * Method for decrypt the password , 
     * @param encryptedPassword
     * @param secret i.e Test declared above
     * @return
     */
	 public static String decrypt(String encryptedPassword) {
		 LOGGER.debug("Decrypting the password");
	        try
	        {
	        	byte[] decodeString = org.apache.commons.codec.binary.Base64.decodeBase64(encryptedPassword.getBytes());

	    		return new String(decodeString);
	        } 
	        catch (Exception e) {
	            System.out.println("Error while decrypting: " + e.toString());
	   		 LOGGER.error("Password decryption failed");

	        }
	        return null;
	    }
	 
	 /**
	  * @author GRANDIS
	  * Method for encrypt the password which has provided
	  * @param strToEncrypt
	  * @param secret i.e Test
	  * @return
	  */
	 public static String encrypt(String strToEncrypt) 
	    {
	        try
	        {
	    		byte[] encodedString = org.apache.commons.codec.binary.Base64.encodeBase64(strToEncrypt.getBytes());
	    		System.out.println(new String(encodedString));
	    		return new String(encodedString);
			 
	        } 
	        catch (Exception e) 
	        {
	            System.out.println("Error while encrypting: " + e.toString());
		   		 LOGGER.error("Password Enryption failed");

	        }
	        return null;
	    }
	 
	 public static void main(String args[]) {
		 //provide password to encrypt after encrypt delete password parameter, give some juck data
			String encodedPasswor=PasswordEncryptDcrypt.encrypt("UmFrc2hhQDA3MTE=");
			LOGGER.info(encodedPasswor);
			LOGGER.info("Copy the Encoded password and paste it in the property File");
			
	 }
}
