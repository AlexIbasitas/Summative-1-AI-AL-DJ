package com.company.summative_one.Controllers;

import com.company.summative_one.Models.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Magic8Controller.class)
class Magic8ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();


    @BeforeEach
    void setUp() {
    }

    @Test
    public void shouldReturnStatusCode201OnPostRequest() throws Exception{
        // ARRANGE
        Answer newQuestion = new Answer();
       // newQuestion.setId(1);
        newQuestion.setQuestion("Do you like dogs?");

        String inputJson = mapper.writeValueAsString(newQuestion);

        // ACT
        mockMvc.perform( // mock test
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
        // ASSERT
                .andExpect(status().isCreated());
    }
}