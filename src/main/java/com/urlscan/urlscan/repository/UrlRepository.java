package com.urlscan.urlscan.repository;

import com.urlscan.urlscan.model.MalwareUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UrlRepository extends JpaRepository<MalwareUrl, Integer> {
//    boolean findByMalwareUrlContaining(String hostname_and_port);


    @Query("Select m from MalwareUrl m where m.host like %:host% " +
            "and m.path like %:path% and m.port = :port and m.queryString like %:queryString%")
    List<MalwareUrl> findByMalwareUrlContaining(String host,
                                       String path, int port, String queryString
    );
}
