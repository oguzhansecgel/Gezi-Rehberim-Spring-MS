package com.gezi_rehberim.comment_service.service.concretes;

import com.gezi_rehberim.comment_service.client.PlaceClient;
import com.gezi_rehberim.comment_service.client.UserClient;
import com.gezi_rehberim.comment_service.core.dto.request.comment.CreateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.request.comment.UpdateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.response.comment.CreateCommentResponse;
import com.gezi_rehberim.comment_service.core.dto.response.comment.UpdateCommentResponse;
import com.gezi_rehberim.comment_service.core.exception.comment.CommentNotFoundException;
import com.gezi_rehberim.comment_service.core.exception.place.PlaceNotFoundException;
import com.gezi_rehberim.comment_service.core.exception.user.UserNotFoundException;
import com.gezi_rehberim.comment_service.core.mapper.CommentMapper;
import com.gezi_rehberim.comment_service.core.message.comment.CommentMessage;
import com.gezi_rehberim.comment_service.core.message.place.PlaceMessage;
import com.gezi_rehberim.comment_service.core.message.user.UserMessage;
import com.gezi_rehberim.comment_service.model.Comment;
import com.gezi_rehberim.comment_service.model.Place;
import com.gezi_rehberim.comment_service.model.User;
import com.gezi_rehberim.comment_service.repository.CommentRepositories;
import com.gezi_rehberim.comment_service.service.abstracts.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepositories commentRepositories;
    private final PlaceClient placeClient;
    private final UserClient userClient;

    public CommentServiceImpl(CommentRepositories commentRepositories, PlaceClient placeClient, UserClient userClient) {
        this.commentRepositories = commentRepositories;
        this.placeClient = placeClient;
        this.userClient = userClient;
    }

    @Override
    public CreateCommentResponse createComment(CreateCommentRequest createCommentRequest) {
        // refactor exception handler
        Optional<Place> place = placeClient.getPlaceById(createCommentRequest.getPlaceId());
        Optional<User> user = userClient.getUserById(createCommentRequest.getUserId());
        if(place.isEmpty())
            throw new PlaceNotFoundException(PlaceMessage.PLACE_NOT_FOUND);
        if (user.isEmpty())
            throw new UserNotFoundException(UserMessage.USER_NOT_FOUND);
        Place getPlace =  place.get();
        User getUser = user.get();
        Comment comment = CommentMapper.INSTANCE.createComment(createCommentRequest);
        comment.setUser(getUser);
        comment.setPlace(getPlace);
        Comment savedComment = commentRepositories.save(comment);
        return new CreateCommentResponse(savedComment.getId(), savedComment.getComment(), savedComment.getPlace(),savedComment.getUser());
    }

    @Override
    public UpdateCommentResponse updateComment(UpdateCommentRequest updateCommentRequest, String commentId) {
        Optional<Comment> optionalComment = commentRepositories.findById(commentId);
        if (optionalComment.isEmpty())
            throw new CommentNotFoundException(CommentMessage.COMMENT_NOT_FOUNT_MESSAGE);
        Comment comment = optionalComment.get();
        Comment updatedComment = CommentMapper.INSTANCE.updateComment(updateCommentRequest,comment);
        Comment savedComment = commentRepositories.save(updatedComment);
        return new UpdateCommentResponse(savedComment.getId(),savedComment.getComment(),savedComment.getPlace(),savedComment.getUser());
    }
}
