package org.iptime.yoon.springbootserver.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author rival
 * @since 2022-02-22
 */
@WebMvcTest(controllers = PageController.class)
class PageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void main_page() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/test"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("test"));
    }

}