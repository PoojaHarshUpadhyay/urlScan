package com.urlscan.urlscan.service;

import org.springframework.stereotype.Service;

@Service
public class CheckUrlService implements ICheckUrlService {
    public boolean isValidUrl() {
        return true;
    }
}
