package com.javaspringlearning.expensetrackerapi.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaspringlearning.expensetrackerapi.Constants;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthFilter extends GenericFilterBean {

    /*
     ** Purpose of the class is to intercept http request and only grant info to
     * people with the proper credentials.
     */

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        /*
         * doFilter method authenticates requests by: 1. Checking for authorization
         * header 2. perform validation, returning forbidden AC and error message if
         * auth code is missing, invalid or expired.
         * 
         */

        // Type casting some arguments from servletRequest to HttpServletRequest.
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // Get the header from the incoming http request, looking at the authorization
        // attribute
        String authHeader = httpRequest.getHeader("Authorization");

        // Validation occurs here
        if (authHeader != null) {
            String[] authHeaderArr = authHeader.split("Bearer ");
            if (authHeaderArr.length > 1 && authHeaderArr[1] != null) {
                String token = authHeaderArr[1];
                try {
                    Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY).parseClaimsJws(token)
                            .getBody();
                    httpRequest.setAttribute("userId", Integer.parseInt(claims.get("userId").toString()));
                } catch (Exception e) {
                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/expired token");
                    return;
                }
            } else {
                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearear [token]");
                return;
            }
        } else {
            httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
