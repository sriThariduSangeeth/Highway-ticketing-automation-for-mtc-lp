package com.sangeeth.hta.lphtaapigatewayservice.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author dtsangeeth
 * @created 12 / 03 / 2021
 * @project lp-hta-api-gateway-service
 */
@Slf4j
@Component
public class JWTRequestFilter implements GlobalFilter, Ordered  {

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String authorization = exchange.getRequest().getHeaders().get("Authorization").get(0);
        String token = null;
        String userName = null;
        Claims claims;
        if(null != authorization && authorization.startsWith("Bearer ")){
            token = authorization.substring(7);
            try{
                claims = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token).getBody();

            }catch (IllegalArgumentException ieg){
                log.error("Unable to get JWT Token");
            }catch (ExpiredJwtException e){
                log.error("Token has invalid"+ e.getMessage());
            }catch (JwtException ex) {
                log.error("Wrong Token"+ ex.getMessage());
                return null;
            }

        }else if (authorization == null){
            log.info("Does not provide Authorization Header");
        }
        else if (!authorization.startsWith("Bearer ")){
            log.warn("JWT Token does not begin with Bearer");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 20000;
    }

}
