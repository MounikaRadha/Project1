package com.m0wn1la.app2.repository;

import com.m0wn1la.app2.model.PostedData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PostedDataRepository extends JpaRepository<PostedData, Long> {
    @Query("select p from posted_data p where p.endPoint.id=:id")
    Page<PostedData> findPostsByEndPointId(@Param("id") Long endPointId, Pageable pageable);


}
