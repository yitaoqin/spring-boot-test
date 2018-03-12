package com.example.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler
        extends AbstractAuthenticationTargetUrlRequestHandler
        implements LogoutSuccessHandler {

    private static final String BEARER_AUTHENTICATION="Bearer";
    private static final String HEADER_AUTHENTICATION="authorization";

    @Autowired
    private TokenStore tokenStore;
    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        String token=httpServletRequest.getHeader(HEADER_AUTHENTICATION);
        if(token !=null && token.startsWith(BEARER_AUTHENTICATION)){
            OAuth2AccessToken oAuth2AccessToken=tokenStore.readAccessToken(token.split("|")[0]);
            if(oAuth2AccessToken !=null){
                tokenStore.removeAccessToken(oAuth2AccessToken);
            }
        }

    }
}
