package com.gezi_rehberim.comment_service.service.abstracts;

import com.gezi_rehberim.comment_service.core.dto.request.comment.CreateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.request.comment.UpdateCommentRequest;
import com.gezi_rehberim.comment_service.core.dto.response.comment.CreateCommentResponse;
import com.gezi_rehberim.comment_service.core.dto.response.comment.UpdateCommentResponse;

public interface CommentService {

    CreateCommentResponse createComment(CreateCommentRequest createCommentRequest);
    UpdateCommentResponse updateComment(UpdateCommentRequest updateCommentRequest, String commentId);
}
