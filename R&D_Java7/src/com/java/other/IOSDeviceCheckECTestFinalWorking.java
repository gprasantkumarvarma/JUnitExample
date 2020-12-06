package com.java.other;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

public class IOSDeviceCheckECTestFinalWorking {

	public static void main(String[] args) {
		
		String inputKeyFile = "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgTT40lPAmdsgZzsHUgC8QxuD7jMfs9bHS5J+9povi4U+gCgYIKoZIzj0DAQehRANCAATWckfA33nxkOvwQ4RoQi/j/8hNa5miWWrjzGvb/ARF+Qeyf/dTm485LEUg5X6hicqXhwYbeBGU93iaqEWK6l/S";  
		inputKeyFile = inputKeyFile.replaceFirst("-----BEGIN PRIVATE KEY-----", "");  
		inputKeyFile = inputKeyFile.replaceFirst("-----END PRIVATE KEY-----", "");  
		inputKeyFile = inputKeyFile.replaceAll("\\s", ""); 
		String clientSecret = "";  
		try {  
		  final byte[] keyBytes = java.util.Base64.getDecoder().decode(inputKeyFile);  
		  final KeyFactory keyFactory = KeyFactory.getInstance("EC");  
		  final PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(keyBytes));  
		  
		  final Date timestamp = new Date();  
		 // final Date exp = new Date(timestamp.getTime() + ttlMs);  
		  String keyId="Y675RM2YXN";
		  String teamId="4E9K3P7262";
		  
		  // see https://developer.apple.com/documentation/signinwithapplerestapi/generate_and_validate_tokens  
		  final JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.ES256)  
		  .keyID(keyId)  
		  .build();  
		  
		  final JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()  
		  .issuer(teamId)  
		  .issueTime(timestamp)  
		//  .expirationTime(exp)  
		//  .audience(audience)  
		//  .subject(clientId)  
		  .build();  
		  
		  SignedJWT signedJWT = new SignedJWT(header, claimsSet);  
		  JWSSigner signer = new ECDSASigner((java.security.interfaces.ECPrivateKey) privateKey);  
		  signedJWT.sign(signer);  
		  String token = signedJWT.serialize();  
		  
		  System.out.println(token);  
		  clientSecret = token;  
		} catch (Exception e) {  
		  e.printStackTrace();  
		}
	}
}
