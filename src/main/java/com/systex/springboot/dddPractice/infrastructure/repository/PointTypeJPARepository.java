package com.systex.springboot.dddPractice.infrastructure.repository;

import com.systex.springboot.dddPractice.domain.PointType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PointTypeJPARepository extends JpaRepository<PointType, UUID> {

}
