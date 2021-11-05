package com.urlscan.urlscan.service;

import com.urlscan.urlscan.model.UserUrl;
import com.urlscan.urlscan.repository.UserUrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckUrlService implements ICheckUrlService {

    private final UserUrlRepository userUrlRepository;

    public CheckUrlService(UserUrlRepository userUrlRepository) {
        this.userUrlRepository = userUrlRepository;
    }

    public boolean isValidUrl() {
        List<UserUrl> result = userUrlRepository.findByUserUrlContaining("hi");
        return false;
    }
}
