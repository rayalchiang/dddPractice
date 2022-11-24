package com.systex.springboot.dddPractice.application.rest;

import com.systex.springboot.dddPractice.application.rest.request.CreatePointTypeRequest;
import com.systex.springboot.dddPractice.application.rest.response.CreatePointTypeResponse;
import com.systex.springboot.dddPractice.application.rest.response.ListPointTypeResponse;
import com.systex.springboot.dddPractice.domain.PointType;
import com.systex.springboot.dddPractice.domain.common.service.PointTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/points")
public class PointTypeController {

    @Autowired
    private PointTypeService pointTypeService;

    @PostMapping
    CreatePointTypeResponse createPointType(@RequestBody CreatePointTypeRequest createPointTypeRequest) {
        PointType type = new PointType(createPointTypeRequest.getType(),createPointTypeRequest.getDescription());

        UUID id = pointTypeService.createPointType(type);
        return new CreatePointTypeResponse(id);
    }

    @GetMapping("/list")
    ListPointTypeResponse listPointType() {
        ListPointTypeResponse response = new ListPointTypeResponse();
        response.setPointTypes(pointTypeService.allTypes());
        return response;
    }
}
