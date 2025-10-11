package com.nyxelis.mapper;

import com.nyxelis.dto.DtoPost;
import com.nyxelis.dto.DtoPostIU;
import com.nyxelis.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PostMapper {
    DtoPost toPostDto(Post post);
    Post toPostIUEntity(DtoPostIU dtoPostIU);

    void updatePostEntityFromDto(DtoPostIU dtoPost, @MappingTarget Post post);
}
