package org.koreait.global.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {
    @Lazy
    @Bean
    public ModelMapper modelMapper(){

        ModelMapper mapper = new ModelMapper();

        //set과 get의 자료형이 다르면 setter하지 않음
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper;
    }
}
