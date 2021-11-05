package com.urlscan.urlscan.service;

import com.urlscan.urlscan.model.MalwareUrl;
import com.urlscan.urlscan.repository.UrlRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CheckUrlServiceTest {

    @Autowired
    private ICheckUrlService checkUrlService;

    @MockBean
    private UrlRepository userUrlRepository;

    @BeforeEach
    public void setUp() {
        this.userUrlRepository = mock(UrlRepository.class);
    }

    @Test
    public void testIsValidUrl() {
        String hostname = "test";
        int port = 80;
        String queryString = "test";
        String path = "test";
        when(this.userUrlRepository.existsById(1)).thenReturn(false);
        boolean result = checkUrlService.isValidUrl(hostname, port, queryString, path);
        assertFalse(result);
    }
}
