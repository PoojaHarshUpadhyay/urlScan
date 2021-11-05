package com.urlscan.urlscan.controller;

import com.urlscan.urlscan.model.UserUrl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("urlinfo")
public class UrlScanController {

    @GetMapping(value = "/{hostname_and_port}/{original_path_and_query_string}", produces = "application/json")
    public String getUrl(@PathVariable String hostname_and_port,
                         @PathVariable String original_path_and_query_string) {
        return "hi";
    }
}
