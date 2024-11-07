package ar.edu.unq.grupo3.theCanchita.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("http://localhost:5173"
				.allowedOriginPatterns("GET","POST","PUT","DELETE")
				.allowedHeaders("Authorization","Content-Type")
				.allowCredentials(true);
		
	}
	
}
