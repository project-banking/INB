package com.diaspark.INB.config;

import com.diaspark.INB.entity.UserPrincipal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);


    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    //The JWT signature algorithm we will be using to sign the token
    private SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    public String generateToken(UserPrincipal userPrincipal) throws JsonProcessingException {

        //Generate signing key for jwt
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtSecret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        String subject = jacksonObjectMapper.writeValueAsString(userPrincipal);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(userPrincipal.getNow())
                .setExpiration(userPrincipal.getExpireAt())
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    /*public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;*/
    
}
