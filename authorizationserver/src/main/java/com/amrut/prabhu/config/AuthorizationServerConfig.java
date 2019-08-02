package com.amrut.prabhu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.AccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private JdbcClientDetailsService jdbcClientDetailsService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenStore tokenStore;

  @Autowired
  private AccessTokenConverter tokenConverter;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients.withClientDetails(jdbcClientDetailsService);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        // .userApprovalHandler(userApprovalHandler) // Only for asking approval from user e.g read scope etc. during authorization_code flow
        .authenticationManager(authenticationManager)
        .tokenStore(tokenStore)
        .accessTokenConverter(tokenConverter);

  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security
        .tokenKeyAccess("hasAuthority('ROLE_CLIENT')")
        .checkTokenAccess("hasAuthority('ROLE_CLIENT')");

  }
}
