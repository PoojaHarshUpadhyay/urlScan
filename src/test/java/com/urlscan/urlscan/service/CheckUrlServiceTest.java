package com.urlscan.urlscan.service;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckUrlServiceTest {

    private ICheckUrlService checkUrlService;

    @BeforeEach
    public void setUp() {
        this.checkUrlService = new CheckUrlService();
    }

    @Test
    public void testIsValidUrl() {
        boolean result = checkUrlService.isValidUrl();
        assertFalse(result);
    }
}
