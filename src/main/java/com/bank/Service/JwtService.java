package com.bank.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {

    private static final String  SECRET_KEY = "6D782EC3E9B134877A6D2A1F3B53E";

    public String extractUsername(String token) {
        return null;
    }

    private Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKey()).parseClaimsJws(token).getBody();
    }

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
