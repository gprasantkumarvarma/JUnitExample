package com.java.other;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
    Our simple static class that demonstrates how to create and decode JWTs.
 */
public class JWTDemo {

    // The secret key. This should be in a property file NOT under source
    // control and not hard coded in real life. We're putting it here for
    // simplicity.
    private static String SECRET_KEY = "MIGTAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBHkwdwIBAQQggyjhAQszbULjI1HlZBGeezvwPfaa6CVgkXmrxs1rWpSgCgYIKoZIzj0DAQehRANCAAQxYVkZOo8pB5U6OLFUURa8DRA2bvyhj9JyQffc5/5YHXMZGihqfTSz/suW91+xABy5z6jsR9GChP2MLbkACx2h";

    //Sample method to construct a JWT
    public static String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.ES256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

  /*      Map<String, Object> headData = new HashMap<>();
        headData.put("alg", "ES256");
        headData.put("kid", "A25CBFY6W3");
        
        Map<String, Object> payloadData = new HashMap<>();
        payloadData.put("iss", "UX4479R35Y");
        payloadData.put("iat", "123456");*/
        
        
        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setIssuer("UX4479R35Y")
        		.setIssuedAt(now)
                .signWith(signatureAlgorithm, signingKey)
                ;

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
System.out.println("builder ::"+builder.compact());
        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
public static void main(String[] args) {
	createJWT("yiyqiue", "wewe", "iuidw",  System.currentTimeMillis());
}
}
