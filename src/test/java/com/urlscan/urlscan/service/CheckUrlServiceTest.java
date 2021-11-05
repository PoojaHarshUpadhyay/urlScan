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
        String hostname_and_port = "test";
        String original_path_and_query_string = "test";
        when(this.userUrlRepository.existsById(1)).thenReturn(false);
        boolean result = checkUrlService.isValidUrl(hostname_and_port,
                original_path_and_query_string);
        assertFalse(result);
    }
}
