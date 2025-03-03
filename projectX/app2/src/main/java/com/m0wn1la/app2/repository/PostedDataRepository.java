package com.m0wn1la.app2.repository;

import com.m0wn1la.app2.model.PostedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostedDataRepository extends JpaRepository<PostedData, Long> {
}
