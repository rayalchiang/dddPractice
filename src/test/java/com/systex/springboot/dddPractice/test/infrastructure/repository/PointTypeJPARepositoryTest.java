package com.systex.springboot.dddPractice.test.infrastructure.repository;

import com.systex.springboot.dddPractice.domain.PointType;
import com.systex.springboot.dddPractice.infrastructure.repository.PointTypeJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class PointTypeJPARepositoryTest {
    @Autowired
    private PointTypeJPARepository repository;

    @Test
    void repositoryNotNull() {
        assertNotNull(repository);
    }

    @Test
    void savePointType(){
        PointType t = repository.save(new PointType("sample1", "Detail1"));
        assertThat(repository.findById(t.getTypeId())).isNotNull();
    }

}
