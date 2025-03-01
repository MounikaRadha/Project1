package com.m0wn1la.app2.repository;

import com.m0wn1la.app2.model.EndPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EndPointRepository extends JpaRepository<EndPoint, Long> , JpaSpecificationExecutor<EndPoint> {
}
