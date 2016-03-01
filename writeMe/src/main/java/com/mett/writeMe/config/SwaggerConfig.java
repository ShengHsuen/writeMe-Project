package com.mett.writeMe.config;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.paths.RelativeSwaggerPathProvider;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

<<<<<<< HEAD

=======
>>>>>>> 8cadc2bcf83f59a201448c7f9e9797dc94aa3a2b
@Configuration
@EnableSwagger
public class SwaggerConfig implements ServletContextAware{
	
	private SpringSwaggerConfig springSwaggerConfig;
	private ServletContext servletContext;
	 
	@Autowired
	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}
	@Bean
	// Don't forget the @Bean annotation
	public SwaggerSpringMvcPlugin customImplementation() {
		RelativeSwaggerPathProvider relativeSwaggerPathProvider = new RelativeSwaggerPathProvider(servletContext);
        relativeSwaggerPathProvider.setApiResourcePrefix("writeMe");
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
        .pathProvider(relativeSwaggerPathProvider);
        
	}
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("writeMe API", "API for writeMe",
				"writeMe API terms of service", "writeMe email",
				"writeMe API Licence Type", "writeMe API License URL");
		return apiInfo;
	}
	
<<<<<<< HEAD
=======
	
	
>>>>>>> 8cadc2bcf83f59a201448c7f9e9797dc94aa3a2b
	@Override
	 public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
