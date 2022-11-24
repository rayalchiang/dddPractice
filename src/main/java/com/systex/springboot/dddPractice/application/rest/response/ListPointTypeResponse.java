package com.systex.springboot.dddPractice.application.rest.response;

import com.systex.springboot.dddPractice.domain.PointType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListPointTypeResponse {
    private List<PointType> pointTypes;
}
