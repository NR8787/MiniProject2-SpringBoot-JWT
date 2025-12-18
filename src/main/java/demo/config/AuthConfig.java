package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration
public class AuthConfig {
	
	public AuthenticationManager authenticationManager (
			AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	                                                         
	
	

}
