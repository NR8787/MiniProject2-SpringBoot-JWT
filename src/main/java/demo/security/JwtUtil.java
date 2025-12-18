package demo.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
	
	private final Key key  = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	private static final long EXPIRATION_TIME =  1000 *60*60;
	
	public  String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(key)
				.compact();
				
	}
	
	public String extractUsername(String token) {
		Claims claims =                  Jwts.parserBuilder()
		                                           .setSigningKey(key)
		                                              .build()
		                                           .parseClaimsJws(token)
		                                               .getBody();
		                  
		                  return claims.getSubject();
	}

}
