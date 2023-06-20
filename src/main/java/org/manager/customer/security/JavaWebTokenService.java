package org.manager.customer.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JavaWebTokenService {

	private String KEY = "secreats";

	/**
	 * Create a new token based on username and returns.
	 * 
	 * @param username
	 * @return
	 */
	public String getToken(final String username) {
		return createToken(new HashMap<String, Object>(), username);
	}

	private String createToken(final Map<String, Object> claims, final String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setId(UUID.randomUUID().toString()).setExpiration(new Date(System.currentTimeMillis() + 100000))
				.signWith(SignatureAlgorithm.HS256, KEY).compact();
	}

	public String extractUseruame(final String token) {
		Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public String createValidTokenForUser(final String token, final UserDetails user) {
		return createToken(new HashMap<String, Object>(), user.getUsername());
	}

	public boolean isTokenValid(final String token) {
		try {
			Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUseruame(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
}
