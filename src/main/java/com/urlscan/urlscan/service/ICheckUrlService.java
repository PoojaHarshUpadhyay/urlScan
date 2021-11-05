package com.urlscan.urlscan.service;

public interface ICheckUrlService {
    boolean isValidUrl(String hostname , int port,String queryString,
                       String originalPath);
}
