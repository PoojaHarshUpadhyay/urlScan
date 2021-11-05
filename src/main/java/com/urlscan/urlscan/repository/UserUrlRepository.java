package com.urlscan.urlscan.repository;

import com.urlscan.urlscan.model.UserUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserUrlRepository extends JpaRepository<UserUrl, Long> {
        List<UserUrl> findByUserUrlContaining(String userUrl);
}
