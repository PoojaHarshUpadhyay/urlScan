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

    @Query("select m from MalwareUrl m where m.host like %?1 or  m.port like %?2 " +
            "or  m.path like %?3 or  m.queryString like %?4")
    boolean findByMalwareUrlContaining(String host,
                                       int port, String path, String queryString
                                       );
}
