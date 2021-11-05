package com.urlscan.urlscan.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(UrlScanController.class)
public class UrlScanControllerTest {

    @Autowired
    private UrlScanController urlScanController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUrl() throws Exception {
        String url = "/urlinfo/host/original";
        mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
    }

}
