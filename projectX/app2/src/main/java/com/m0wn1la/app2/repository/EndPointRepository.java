package com.m0wn1la.app2.repository;

import com.m0wn1la.app2.model.EndPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EndPointRepository extends JpaRepository<EndPoint, Long>, JpaSpecificationExecutor<EndPoint> {
    @Query("select  e from end_points e order by e.id desc")
    Page<EndPoint> findAllOrderByIdDesc(Pageable pageable);
}
