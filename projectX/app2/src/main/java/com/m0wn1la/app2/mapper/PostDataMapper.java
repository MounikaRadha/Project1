package com.m0wn1la.app2.mapper;

import com.m0wn1la.app2.dto.PostedDataDTO;
import com.m0wn1la.app2.model.PostedData;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PostDataMapper {
    @Mapping(source = "id", target = "postId")
    @Mapping(source = "postedBy.id", target = "postedBy.userId")
    PostedDataDTO postDataToPostedDataDTO(PostedData postedData);

}
