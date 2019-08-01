package com.amrut.prabhu.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfiguration {

  @Bean
  public JdbcClientDetailsService jdbcClientDetailsService(DataSource dataSource){
    return new JdbcClientDetailsService(dataSource);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  @Bean
  public JwtAccessTokenConverter tokenConverter(){
    JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
    jwtAccessTokenConverter.setSigningKey("1234567");
    return jwtAccessTokenConverter;
  }

  @Bean
  public JwtTokenStore tokenStore(JwtAccessTokenConverter tokenConverter){
    return new JwtTokenStore(tokenConverter);
  }
}
