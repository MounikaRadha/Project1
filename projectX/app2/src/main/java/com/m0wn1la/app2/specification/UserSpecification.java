package com.m0wn1la.app2.specification;

import com.m0wn1la.app2.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@Data
public class UserSpecification {
    public static Specification<User> findByUsername(String username) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userName"), username);
    }
}
