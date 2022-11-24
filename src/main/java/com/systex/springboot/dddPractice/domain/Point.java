package com.systex.springboot.dddPractice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Point {
    PointType type;
    PointStatus status;
    float value;
}
