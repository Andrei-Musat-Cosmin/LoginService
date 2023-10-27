package it.sincrono.services;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	/** SECRET KEY **/
	private static final String SECRET_KEY = "4935deb64149bb901aa558f65169afc9e3271ba688ba0669936d0f0a4c2e539c";

	/** ESTRATTORI DI DATI **/
	public String extractUsername(String jwt) {
		return extractClaims(jwt, Claims::getSubject);
	}

	private Date extractExpiration(String jwt) {
		return extractClaims(jwt, Claims::getExpiration);
	}

	/** CONTROLLO PER VERIFICARE SE L'USER E' VERAMENTE CHI DICE DI ESSERE **/
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token).getBody();
	}

	/** ESTRARRE TUTTE LE DICHIARAZIONI **/
	public <T> T extractClaims(String jwt, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(jwt);
		return claimsResolver.apply(claims);
	}

	private Key getSignInKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	/** METODO PER GENERARE IL TOKEN CHE CONTIENE LE DICHIARAZIONI **/
	public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {

		return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername()) // L'UTENTE ALLA QUALE VIENE
																							// ASSEGNATO IL TOKEN
				.setIssuedAt(new Date(System.currentTimeMillis())) // DATA DI LOGIN O CREAZIONE DEL TOKEN
				.setExpiration(new Date(System.currentTimeMillis() + 32400000)) // DATA DI SCADENTA DEL TOKEN
				.signWith(getSignInKey(), SignatureAlgorithm.HS256) // QUALE CHIAVE USARE E LA LUNGHEZZA
				.compact();
	}

	public String generateToken(UserDetails userDetails) {
		return generateToken(new HashMap<>(), userDetails);
	}

	/** METODI PER VALIDARE IL TOKEN (CORRETTEZZA, SCADENZA) **/
	public boolean isTokenValid(String jwt, UserDetails userDetails) {
		final String username = extractUsername(jwt);
		return (username.equals(userDetails.getUsername())) && !isTokenExpired(jwt);
	}

	private boolean isTokenExpired(String jwt) {
		return extractExpiration(jwt).before(new Date());
	}

}
