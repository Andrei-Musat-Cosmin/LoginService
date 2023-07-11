package it.sincrono.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import it.sincrono.services.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailsService userDetailsService;

	/** VERRA CHIAMATO OGNI VOLTA CHE SI EFFETTUA UNA RICHIESTA **/
	@Override
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws ServletException, IOException {

		// CONTROLLO DELLA PRESENZA DEL TOKEN NELLA RICHIESTA
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String username;

		// SE E' NULLO OPPURE SE NON INIZIA CON "Bearer "
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		// SET DEL TOKEN SENZA L'INIZIO DELLA STRINGA "Bearer "
		jwt = authHeader.substring(7);

		// RICAVARE L'USERNAME TRAMITE IL TOKEN
		username = jwtService.extractUsername(jwt);

		// CONTROLLO SE L'USER E' GIA AUTENTICATO
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if (jwtService.isTokenValid(jwt, userDetails)) { // SE IL TOKEN E' VALIDO
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
						null, userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
