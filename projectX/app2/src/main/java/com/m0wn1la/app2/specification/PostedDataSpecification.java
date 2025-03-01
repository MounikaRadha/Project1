package com.m0wn1la.app2.specification;

import com.m0wn1la.app2.model.EndPoint;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@Data
public class PostedDataSpecification {
    public static Specification<EndPoint> findByEndPointName(String endPointName) {
        //TODO
        //select * from PostedData from postedData join endPoints where postedData.endPoint=endPoint.id and endPoint.endPointName=:endPointName
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("endPoint"), endPointName);
    }
}
