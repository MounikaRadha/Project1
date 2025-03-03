package com.m0wn1la.app2.mapper;

import com.m0wn1la.app2.dto.EndPointDTO;
import com.m0wn1la.app2.dto.EndPointDTOWithUserDTO;
import com.m0wn1la.app2.model.EndPoint;
import com.m0wn1la.app2.request.EndPointPostRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {UserMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface EndPointMapper {
    EndPointDTO endPointToEndPointDTO(EndPoint endPoint);

    @Mapping(source = "ownedBy", target = "owner")
    EndPointDTOWithUserDTO endPointToEndPointDTOWithUser(EndPoint endPoint);

    void mergeEndPointPostRequestToEndPoint(EndPointPostRequest request, @MappingTarget EndPoint endPoint);
}
