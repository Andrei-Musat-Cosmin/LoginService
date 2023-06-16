package it.sincrono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import it.sincrono.services.impl.JwtService;
import it.sincrono.services.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

    @Autowired
    private JwtService jwtService;

   /* @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("Authorization");

        String username = null;
        String jwtToken = null;

        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            jwtToken = requestTokenHeader.substring(7);
            try {
                username = jwtUtil.getUsernameFromToken(jwtToken);
            } catch (IllegalArgumentException e) {
                System.out.println("Unable to get JWT Token");
            } catch (ExpiredJwtException e) {
                System.out.println("JWT Token has expired");
            }
        } else {
            System.out.println("JWT token does not start with Bearer");
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = jwtService.loadUserByUsername(username);

            if (jwtUtil.validateToken(jwtToken, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);

    }*/
    	
    	 private List<String> excludedPaths = Arrays.asList("/login");

    	    @Override
    	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
    	            throws ServletException, IOException {

    	        String requestPath = request.getRequestURI();

    	        // Controlla se il percorso della richiesta corrisponde a uno degli esclusi
    	        if (isExcludedPath(requestPath)) {
    	            // Ignora l'esecuzione del filtro e passa alla catena successiva
    	            filterChain.doFilter(request, response);
    	            return;
    	        }

    	        // Altrimenti, esegui la logica del filtro
    	        // ...

    	        // Chiamata alla catena dei filtri successiva
    	        filterChain.doFilter(request, response);
    	    }

    	    private boolean isExcludedPath(String requestPath) {
    	        return excludedPaths.contains(requestPath);
    	    }



}
