package com.systex.springboot.dddPractice.infrastructure.repository;

import com.systex.springboot.dddPractice.domain.PointType;
import com.systex.springboot.dddPractice.domain.common.repository.PointTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PointTypeDBRepository implements PointTypeRepository {
    @Autowired
    private PointTypeJPARepository repository;
    @Override
    public List<PointType> getAll() {
        return repository.findAll();
    }

    @Override
    public UUID save(PointType type) {
        PointType t = repository.save(new PointType(type.getType(), type.getDescription()));
        return t.getTypeId();
    }

    @Override
    public Optional<PointType> findById(UUID id) {
        return repository.findById(id);
    }
}
