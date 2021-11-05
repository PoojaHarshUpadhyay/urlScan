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

    public boolean isValidUrl(String hostname, int port, String queryString,
                              String originalPath) {
        boolean res;
        List<MalwareUrl> result = urlRepository.findByMalwareUrlContaining(hostname,
                queryString, port, originalPath);
        res = result.size() <= 0;
        return res;
    }
}
