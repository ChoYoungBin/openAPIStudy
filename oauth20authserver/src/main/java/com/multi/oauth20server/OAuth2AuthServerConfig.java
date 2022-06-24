package com.multi.oauth20server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.sql.DataSource;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public JwtAccessTokenConverter tokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("SECRET_KEY");
        return converter;
    }
    public TokenStore tokenStore() {
        //return new JdbcTokenStore(dataSource);
        return new JwtTokenStore(tokenConverter());
    }

    public JdbcApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }

    public JdbcAuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .accessTokenConverter(tokenConverter())
                .approvalStore(approvalStore())
                .authorizationCodeServices(authorizationCodeServices());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client1").secret(passwordEncoder.encode("1234"))
                .authorizedGrantTypes("authorization_code", "implicit", "password", "client_credentials",
                        "refresh_token")
                .scopes("contacts", "profiles", "messages").authorities("TEST_CLIENT")
                .redirectUris("http://jcornor.com:8080/callback", "http://localhost:8080/callback")
                .accessTokenValiditySeconds(3600).refreshTokenValiditySeconds(0);
    }
}
