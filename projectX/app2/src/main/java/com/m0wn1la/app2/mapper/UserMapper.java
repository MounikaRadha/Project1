package com.m0wn1la.app2.mapper;

import com.m0wn1la.app2.dto.UserDTO;
import com.m0wn1la.app2.model.User;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    @Mapping(target = "username" ,source = "userName")
    UserDTO userToUserDTO(User user);
}
