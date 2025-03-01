package com.m0wn1la.app2.specification;

import com.m0wn1la.app2.model.EndPoint;
import com.m0wn1la.app2.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@Data
public class EndPointSpecification {
    public static Specification<EndPoint> findByName(String endPointName) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("endPoint"), endPointName);
    }
}
