package com.urlscan.urlscan.service;

public interface ICheckUrlService {
    boolean isValidUrl(String hostname_and_port,
                       String original_path_and_query_string);
}
