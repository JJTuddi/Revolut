package com.app.banking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

public class BaseControllerTest {
    protected MockMvc mockMvc;

    @BeforeEach
    protected void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    protected ResultMatcher jsonContentToBe(Object expectedJsonContent) throws JsonProcessingException {
        return content().json(new ObjectMapper().writeValueAsString(expectedJsonContent), true);
    }

    protected ResultActions performPostWithRequestBody(String path, Object body) throws Exception {
        MockHttpServletRequestBuilder sth = post(path)
                .content(asJsonString(body))
                .contentType(MediaType.APPLICATION_JSON);
        return mockMvc.perform(sth.accept(MediaType.APPLICATION_JSON));
    }

    protected ResultActions performPutWithRequestBody(String path, Object body) throws Exception {
        return mockMvc.perform(put(path)
                .content(asJsonString(body))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

    protected ResultActions performGet(String path) throws Exception {
        return mockMvc.perform(get(path));
    }


    protected ResultActions performPatchWithRequestBodyAndPathVariable(String path, Object body, Object pathVariable) throws Exception {
        return mockMvc.perform(jsonType(patch(path, pathVariable)
                .content(asJsonString(body)))
        );
    }

    protected ResultActions performDeleteWIthPathVariable(String path, Object pathVariable) throws Exception {
        return mockMvc.perform(jsonType(delete(path, pathVariable)));
    }

    protected String asJsonString(final Object obj) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private RequestBuilder jsonType(MockHttpServletRequestBuilder content) {
        return content.contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON);
    }
}
