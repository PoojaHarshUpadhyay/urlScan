package com.urlscan.urlscan.repository;

import com.urlscan.urlscan.model.MalwareUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends CrudRepository<MalwareUrl, Integer> {
//    boolean findByMalwareUrlContaining(String hostname_and_port);
}
