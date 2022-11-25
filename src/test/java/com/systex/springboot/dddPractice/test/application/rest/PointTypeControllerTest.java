package com.systex.springboot.dddPractice.test.application.rest;

import com.systex.springboot.dddPractice.application.rest.PointTypeController;
import com.systex.springboot.dddPractice.domain.PointType;
import com.systex.springboot.dddPractice.domain.common.service.PointTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PointTypeController.class)
public class PointTypeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PointTypeService service;

    @Test
    void hasEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/points/list")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


    @Test
    void doesNotHaveEndPoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void getAllRecords() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes", hasSize(0)));
    }

    private static final PointType T1 = new PointType("title1", "detail1");
    private static final PointType T2 = new PointType("title2", "detail2");
    private static final PointType T3 = new PointType("title3", "detail3");

    @Test
    void getAllRecords2() throws Exception {
        List<PointType> records = new ArrayList<>(Arrays.asList(T1, T2, T3));

        Mockito.when(service.allTypes()).thenReturn(records);
        mockMvc.perform(MockMvcRequestBuilders.get("/points/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pointTypes", hasSize(3)));
    }

}
