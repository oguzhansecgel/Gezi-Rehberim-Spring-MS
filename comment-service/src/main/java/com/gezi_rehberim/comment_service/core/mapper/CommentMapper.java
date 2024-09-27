package com.gezi_rehberim.comment_service.core.mapper;

import com.gezi_rehberim.comment_service.core.dto.request.comment.CreateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.request.comment.UpdateCommentRequest;
import com.gezi_rehberim.comment_service.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {


    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "placeId",target = "place.id")
    @Mapping(source = "userId",target = "user.id")
    Comment createComment(CreateCommentRequest createCommentRequest);

    @Mapping(source = "placeId",target = "place.id")
    @Mapping(source = "userId",target = "user.id")
    Comment updateComment(UpdateCommentRequest updateCommentRequest,@MappingTarget Comment comment);

}
