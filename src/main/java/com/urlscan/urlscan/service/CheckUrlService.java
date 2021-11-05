package com.urlscan.urlscan.service;

import com.urlscan.urlscan.model.MalwareUrl;
import com.urlscan.urlscan.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CheckUrlService implements ICheckUrlService {

    @Autowired
    private UrlRepository urlRepository;

    public boolean isValidUrl(String hostname_and_port,
                              String original_path_and_query_string) {
        boolean result = urlRepository.existsById(1);
        return result;
    }
}
