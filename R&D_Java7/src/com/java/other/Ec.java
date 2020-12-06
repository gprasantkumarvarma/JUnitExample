package com.java.other;
import java.util.Date;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.*;
import com.nimbusds.jose.jwk.*;
import com.nimbusds.jose.jwk.gen.*;
import com.nimbusds.jwt.*;

public class Ec {
    private static String SECRET_KEY = "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQgTT40lPAmdsgZzsHUgC8QxuD7jMfs9bHS5J+9povi4U+gCgYIKoZIzj0DAQehRANCAATWckfA33nxkOvwQ4RoQi/j/8hNa5miWWrjzGvb/ARF+Qeyf/dTm485LEUg5X6hicqXhwYbeBGU93iaqEWK6l/S";

	public static void main(String[] args) throws JOSEException {
		
		long nowMillis = System.currentTimeMillis()/ 1000L;
        Date now = new Date(nowMillis);
        
        System.out.println(System.currentTimeMillis());
        
		// Generate an EC key pair
		ECKey ecJWK = new ECKeyGenerator(Curve.P_256)
	    .keyID(SECRET_KEY)
	    .generate();
	ECKey ecPublicJWK = ecJWK.toPublicJWK();

	// Create the EC signer
	JWSSigner signer = new ECDSASigner(ecJWK);

	// Prepare JWT with claims set
	JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
	    //.subject("alice")
	    .issuer("4E9K3P7262")
	    .issueTime(now)
	    //.expirationTime(new Date(new Date().getTime() + 60 * 1000))
	    .build();

	SignedJWT signedJWT = new SignedJWT(
	    new JWSHeader.Builder(JWSAlgorithm.ES256).keyID("Y675RM2YXN").build(),
	    claimsSet);

	// Compute the EC signature
	signedJWT.sign(signer);

	// Serialize the JWS to compact form
	String s = signedJWT.serialize();

	System.out.println(s);
/*	// On the consumer side, parse the JWS and verify its EC signature
	signedJWT = SignedJWT.parse(s);

	JWSVerifier verifier = new ECDSAVerifier(ecPublicJWK);
	assertTrue(signedJWT.verify(verifier));

	// Retrieve / verify the JWT claims according to the app requirements
	assertEquals("alice", signedJWT.getJWTClaimsSet().getSubject());
	assertEquals("https://c2id.com", signedJWT.getJWTClaimsSet().getIssuer());
	assertTrue(new Date().before(signedJWT.getJWTClaimsSet().getExpirationTime()));}*/
	}

}
