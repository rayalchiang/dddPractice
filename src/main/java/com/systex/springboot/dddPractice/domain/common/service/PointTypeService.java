package com.systex.springboot.dddPractice.domain.common.service;

import com.systex.springboot.dddPractice.domain.PointType;

import java.util.List;
import java.util.UUID;

public interface PointTypeService {
    UUID createPointType(PointType type);
    List<PointType> allTypes();
}
