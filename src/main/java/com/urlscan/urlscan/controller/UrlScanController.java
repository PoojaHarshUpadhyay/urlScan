package com.urlscan.urlscan.controller;

import com.urlscan.urlscan.model.MalwareUrl;
import com.urlscan.urlscan.service.ICheckUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("urlinfo")
public class UrlScanController {

    private final ICheckUrlService checkUrlService;

    public UrlScanController(ICheckUrlService checkUrl) {
        this.checkUrlService = checkUrl;
    }

    @GetMapping(value = "/{hostname_and_port}/{original_path_and_query_string}", produces = "application/json")
    public ResponseEntity<MalwareUrl> getUrl(@PathVariable String hostname_and_port,
                                             @PathVariable String original_path_and_query_string) throws MalformedURLException {
        URL url = new URL(hostname_and_port + original_path_and_query_string);
        String hostname = url.getHost();
        int port = url.getPort();
        String queryString =  url.getQuery();
        String path = url.getPath();
        boolean result = checkUrlService.isValidUrl(hostname, port, path, queryString);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
