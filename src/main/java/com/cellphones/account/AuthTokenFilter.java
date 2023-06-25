package com.cellphones.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUltils jwtUltils;
    @Autowired
    private UserDetailsService userDetailsService;
    private static Logger logger= LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwt = parseJwt(request);
        if(jwtUltils.validateJwtToken(jwt) && jwt!= null)
        {
            String userName = jwtUltils.getUserNameFromJwtToken(jwt);
            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),null,userDetails.getAuthorities()
            );
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain. doFilter(request,response);
    }

    private String parseJwt(HttpServletRequest request)
    {
        String headerAuther = request.getHeader("Authorization");
        if(StringUtils.hasText(headerAuther) && headerAuther.startsWith("Bearer"))
        {
            String rs =headerAuther.substring(7,headerAuther.length());
            rs.trim();
            return rs;
        }
        return null;
    }
}
