package com.fabrizio.spring.course.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@PropertySources({ @PropertySource("classpath:values.properties")

})
@Configuration
public class valuesConfig {

}
