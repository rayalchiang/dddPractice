package com.systex.springboot.dddPractice.infrastructure.configuration;

import com.systex.springboot.dddPractice.domain.common.repository.PointTypeRepository;
import com.systex.springboot.dddPractice.domain.common.service.PointTypeService;
import com.systex.springboot.dddPractice.domain.common.service.PointTypeServiceImpl;
import com.systex.springboot.dddPractice.infrastructure.repository.PointTypeMemRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    PointTypeService pointTypeService(final PointTypeRepository repository) {
        return new PointTypeServiceImpl(repository);
    }

    @Bean
    PointTypeRepository pointTypeRepository(){
        return new PointTypeMemRepository();
    }
}
