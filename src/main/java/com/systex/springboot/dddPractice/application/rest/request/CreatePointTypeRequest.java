package com.systex.springboot.dddPractice.application.rest.request;

import com.systex.springboot.dddPractice.domain.PointType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreatePointTypeRequest {
    private String type;
    private String description;
}
