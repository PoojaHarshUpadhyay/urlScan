package com.urlscan.urlscan.controller;

import com.urlscan.urlscan.model.MalwareUrl;
import com.urlscan.urlscan.service.ICheckUrlService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("urlinfo")
public class UrlScanController {

    private final ICheckUrlService checkUrlService;

    public UrlScanController(ICheckUrlService checkUrl) {
        this.checkUrlService = checkUrl;
    }

    @GetMapping(value = "/{hostname_and_port}/{original_path}", produces = "application/json")
    public ResponseEntity getUrl(@PathVariable String hostname_and_port,
                                 @PathVariable String original_path,
                                 HttpServletRequest request) throws MalformedURLException {
        if (hostname_and_port.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass host name and port");
        }
        if (original_path.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please pass the original path");
        }
        String[] temp = hostname_and_port.split(":");
        String hostName = temp[0];
        int port = Integer.parseInt(temp[1]);
        String query;
        if (request.getQueryString() == null) {
            query = "";
        } else {
            String[] tempQuery = request.getQueryString().split("=");
            query = tempQuery[1];
        }
        boolean result = checkUrlService.isValidUrl(hostName, port, original_path, query);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body("It is valid url");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("It is malware url");
        }
    }
}
