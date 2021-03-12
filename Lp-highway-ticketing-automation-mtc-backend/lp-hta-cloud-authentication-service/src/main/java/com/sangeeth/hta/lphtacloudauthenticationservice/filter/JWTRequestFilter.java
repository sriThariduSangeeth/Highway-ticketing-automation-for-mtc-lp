package com.sangeeth.hta.lphtacloudauthenticationservice.filter;

import com.sangeeth.hta.lphtacloudauthenticationservice.services.UserService;
import com.sangeeth.hta.lphtacloudauthenticationservice.utils.JWTTokenUtility;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dtsangeeth
 * @created 21 / 02 / 2021
 * @project lp-hta-cloud-authentication-service
 */
@Component
public class JWTRequestFilter extends OncePerRequestFilter {

    @Autowired
    private JWTTokenUtility jwtTokenUtility;

    @Autowired
    private UserService userService;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader("Authorization");
        String token = null;
        String userName = null;
        Claims claims;

        if(null != authorization && authorization.startsWith("Bearer ")){
            token = authorization.substring(7);
            try{
                claims = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token).getBody();

                userName = jwtTokenUtility.getUsernameFromToken(token);
            }catch (IllegalArgumentException ieg){
                logger.error("Unable to get JWT Token");
            }catch (ExpiredJwtException e){
                logger.error("Token has invalid"+ e.getMessage());
            }catch (JwtException ex) {
                logger.error("Wrong Token"+ ex.getMessage());
            }

        }else if (authorization == null){

            logger.info("Does not provide Authorization Header");

        }
        else if (!authorization.startsWith("Bearer ")){
            logger.warn("JWT Token does not begin with Bearer");
        }

        if(null != userName && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails
                    = userService.loadUserByUsername(userName);

            if(jwtTokenUtility.validateToken(token,userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                        = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(httpServletRequest)
                );

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }

        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
