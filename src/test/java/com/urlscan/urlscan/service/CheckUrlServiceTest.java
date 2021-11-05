package com.urlscan.urlscan.service;

import com.urlscan.urlscan.model.UserUrl;
import com.urlscan.urlscan.repository.UserUrlRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CheckUrlServiceTest {

    private ICheckUrlService checkUrlService;

    private UserUrlRepository userUrlRepository;

    @BeforeEach
    public void setUp() {
        this.userUrlRepository = mock(UserUrlRepository.class);
        this.checkUrlService = new CheckUrlService(userUrlRepository);
    }

    @Test
    public void testIsValidUrl() {
        List<UserUrl> userUrls = new ArrayList<>();
        when(this.userUrlRepository.findByUserUrlContaining("test")).thenReturn(userUrls);
        boolean result = checkUrlService.isValidUrl();
        assertFalse(result);
    }
}
