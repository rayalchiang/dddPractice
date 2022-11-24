package com.systex.springboot.dddPractice.domain.common.repository;

import com.systex.springboot.dddPractice.domain.PointType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PointTypeRepository {
    Optional<PointType> findById(UUID id);

    UUID save(PointType type);

    List<PointType> getAll();
}
