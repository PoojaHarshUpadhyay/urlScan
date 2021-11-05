package com.urlscan.urlscan.controller;

import com.urlscan.urlscan.service.CheckUrlService;
import com.urlscan.urlscan.service.ICheckUrlService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(UrlScanController.class)
public class UrlScanControllerTest {

    @Autowired
    private UrlScanController urlScanController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICheckUrlService checkUrlService;

    @Test
    public void testMalwareGetUrl() throws Exception {
        String url = "/urlinfo/host/original";
        String hostname_and_port = "test";
        String original_path_and_query_string = "test";
        when(this.checkUrlService.isValidUrl(hostname_and_port, original_path_and_query_string)).thenReturn(false);
        mockMvc.perform(get(url)).andDo(print()).andExpect(status().isBadRequest());
    }

//    @Test
//    public void testValidGetUrl() throws Exception {
//        String url = "/urlinfo/host/original";
//        String hostname_and_port = "test";
//        String original_path_and_query_string = "test";
//        when(this.checkUrlService.isValidUrl(hostname_and_port, original_path_and_query_string)).thenReturn(true);
//        mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());
//    }

}
