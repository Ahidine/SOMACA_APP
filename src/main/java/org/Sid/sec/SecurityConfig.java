package org.Sid.sec;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	/*@Autowired
	private javax.sql.DataSource dataSource;
	@Autowired
	BCryptPasswordEncoder bcryptePassowrdEncoder;*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 //TODO Auto-generated method stub
		 auth.inMemoryAuthentication().withUser("somaca").password("{noop}somaca").roles("ADMIN");
	/*	auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("Select username as principal , pass as credentials ,active from users where username = ? ")
		.authoritiesByUsernameQuery("Select username as principal , role as role from users_roles where username = ?")
		.rolePrefix("ROLE_")
		.passwordEncoder(getBcrypte());*/
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
        .authorizeRequests()
           .antMatchers("/login").permitAll()
           .anyRequest().authenticated()
           .and()
        .formLogin()
           .permitAll()
           .and()
           .logout()
           .permitAll();

	}

}
